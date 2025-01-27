package com.example.data

import java.time.LocalDateTime

data class Task(
    val id: Long? = null,
    val title: String,
    val description: String,
    val deadLine: LocalDateTime? = null,
    val isCompleted: Boolean = false
)
