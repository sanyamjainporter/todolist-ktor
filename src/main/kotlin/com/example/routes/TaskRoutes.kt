package com.example.routes

import com.example.domain.TaskRepositoryImpl
import com.example.data.Task
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.request.*

fun Application.taskRoutes(taskRepository: TaskRepositoryImpl) {
    routing {
        route("/tasks") {
            get {
                call.respond(taskRepository.getAllTasks())
            }
            post {
                val task = call.receive<Task>()
                call.respond(HttpStatusCode.Created, taskRepository.createTask(task))
            }
            put("/{id}") {
                val task = call.receive<Task>()
                val id = call.parameters["id"]?.toLongOrNull()
                if (id == null) {
                    call.respond(HttpStatusCode.BadRequest, "Invalid ID")
                } else{
                    call.respond(HttpStatusCode.OK, taskRepository.updateTask(id,task))
                }
            }
            delete("/{id}") {
                val id = call.parameters["id"]?.toLongOrNull()
                if (id == null) {
                    call.respond(HttpStatusCode.BadRequest, "Invalid ID")
                } else {
                    val result = taskRepository.deleteTask(id)
                    if (result) call.respond(HttpStatusCode.NoContent)
                    else call.respond(HttpStatusCode.NotFound)
                }
            }
        }
    }
}
