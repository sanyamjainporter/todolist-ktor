package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import com.example.routes.taskRoutes
import com.example.domain.TaskRepositoryImpl
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import javax.sql.DataSource

fun main() {
    embeddedServer(Netty, port = 8080) {
        module()
    }.start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }

    val dataSource = provideDataSource()
    val taskRepository = TaskRepositoryImpl(dataSource)

    taskRoutes(taskRepository)
}

fun provideDataSource(): DataSource {
    val config = HikariConfig().apply {
        jdbcUrl = "jdbc:mysql://localhost:3306/todolist"
        username = "remote"
        password = "remote"
        driverClassName = "com.mysql.cj.jdbc.Driver"
    }
    return HikariDataSource(config)
}
