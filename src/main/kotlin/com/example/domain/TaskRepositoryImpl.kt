package com.example.domain

import com.example.data.Task
import javax.sql.DataSource
import java.sql.PreparedStatement
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime

class TaskRepositoryImpl(private val dataSource: DataSource) : TaskRepository {

    override fun getAllTasks(): List<Task> {
        val tasks = mutableListOf<Task>()
        val query = "SELECT id, title, description, is_completed FROM tasks"

        dataSource.connection.use { connection ->
            connection.prepareStatement(query).use { statement ->
                val resultSet = statement.executeQuery()
                while (resultSet.next()) {
                    tasks.add(
                        Task(
                            id = resultSet.getLong("id"),
                            title = resultSet.getString("title"),
                            description = resultSet.getString("description"),
                            isCompleted = resultSet.getBoolean("is_completed")
                        )
                    )
                }
            }
        }

        return tasks
    }

    override fun createTask(task: Task): Task {
        val now = LocalDateTime.now()

        val query = """
        INSERT INTO tasks (title, description, is_completed, creation_time, updation_time)
        VALUES (?, ?, ?, ?, ?)
    """.trimIndent()

        dataSource.connection.use { connection ->
            connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS).use { statement ->
                statement.setString(1, task.title)
                statement.setString(2, task.description)
                statement.setBoolean(3, task.isCompleted)
                statement.setTimestamp(4, Timestamp.valueOf(now))  // Use Timestamp for creation_time
                statement.setTimestamp(5, Timestamp.valueOf(now))  // Use Timestamp for updation_time
                val affectedRows = statement.executeUpdate()

                if (affectedRows == 0) {
                    throw RuntimeException("Failed to create task. No rows affected.")
                }

                val generatedKeys = statement.generatedKeys
                if (generatedKeys.next()) {
                    val generatedId = generatedKeys.getLong(1)
                    return task.copy(id = generatedId)
                } else {
                    throw RuntimeException("Failed to retrieve generated ID for the new task")
                }
            }
        }
    }

    override fun updateTask(id: Long, task: Task): Task {
        val now = LocalDateTime.now()
        val query = """
            UPDATE tasks
            SET title = '${task.title}', description = '${task.description}', is_completed = ${task.isCompleted}, updation_time = '${now}'
            WHERE id = ${id}
        """

        dataSource.connection.use { connection ->
            try {
                connection.prepareStatement(query).use{ statement ->
                    statement.executeUpdate()
                }
            } catch (e: Exception) {
                println("e is $e")
                throw e
            }
        }
        return task
    }

    override fun deleteTask(id: Long): Boolean {
        val query = "DELETE FROM tasks WHERE id = ?"

        dataSource.connection.use { connection ->
            connection.prepareStatement(query).use { statement ->
                statement.setLong(1, id)
                return statement.executeUpdate() > 0
            }
        }
    }
}
