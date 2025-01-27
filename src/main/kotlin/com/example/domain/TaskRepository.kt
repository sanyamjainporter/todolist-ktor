package com.example.domain

import com.example.data.Task

interface TaskRepository {
    fun getAllTasks(): List<Task>
    fun createTask(task: Task): Task
    fun deleteTask(id: Long): Boolean
    fun updateTask(id: Long, task: Task): Task
}
