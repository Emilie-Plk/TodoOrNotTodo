package com.laurentvrevin.todoornottodo.data.repository

import com.laurentvrevin.todoornottodo.data.dao.TaskDao
import com.laurentvrevin.todoornottodo.data.entities.TaskEntity
import com.laurentvrevin.todoornottodo.domain.model.Task
import com.laurentvrevin.todoornottodo.domain.model.TaskPriority
import com.laurentvrevin.todoornottodo.domain.model.TaskStatus
import com.laurentvrevin.todoornottodo.domain.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(private val taskDao: TaskDao) : TodoRepository {
    val selectAll = taskDao.getAllTasks()

    override fun getAllTasks(): Flow<List<Task>> = taskDao.getAllTasks().map { entities ->
        entities.map { entity -> entity.toDomain() }
    }

    override suspend fun insertTask(task: Task) {
        withContext(Dispatchers.IO) {
            taskDao.insertTask(task.toEntity())
        }
    }


    override suspend fun deleteTask(id: Int){
        withContext(Dispatchers.IO) {
            taskDao.deleteTask(id)
        }
    }
    override suspend fun updateTask(task: Task) {
        withContext(Dispatchers.IO) {
            taskDao.updateTask(task.toEntity())
        }
    }



    // Extension function to convert TaskEntity to Task
    private fun TaskEntity.toDomain(): Task {
        return Task(
            id = id,
            title = title,
            description = description,
            createDate = createDate,
            deadline = deadline,
            status = TaskStatus.valueOf(status),
            priority = TaskPriority.valueOf(priority),
            order = order
        )
    }

    // Extension function to convert Task to TaskEntity
    private fun Task.toEntity(): TaskEntity {
        return TaskEntity(
            id = id,
            title = title,
            description = description,
            createDate = createDate,
            deadline = deadline,
            status = status.name,
            priority = priority.name,
            order = order
        )
    }


}