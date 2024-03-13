package com.laurentvrevin.todoornottodo.domain.repository

import com.laurentvrevin.todoornottodo.data.model.TaskEntity
import com.laurentvrevin.todoornottodo.domain.model.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface TodoRepository {
    fun getAllTasks(): Flow<List<Task>>
    suspend fun insertTask(task: Task)
    suspend fun updateTask(task: Task)
    suspend fun deleteTask(id: Int)
    //suspend fun deleteAllTasks()
}