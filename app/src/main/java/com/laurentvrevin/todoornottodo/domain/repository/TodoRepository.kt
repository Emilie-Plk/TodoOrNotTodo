package com.laurentvrevin.todoornottodo.domain.repository

import com.laurentvrevin.todoornottodo.domain.model.Task
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun insertTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(id: Int)
    //suspend fun deleteAllTasks()
}