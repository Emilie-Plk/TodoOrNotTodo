package com.laurentvrevin.todoornottodo.domain.model


import java.util.Date

data class Task(
    val id: Int = 0,
    val title:String,
    val description:String,
    val createDate: Date = Date(),
    val deadline: Date,
    val status: TaskStatus,
    val priority: TaskPriority,
    val order: Int? = null
)