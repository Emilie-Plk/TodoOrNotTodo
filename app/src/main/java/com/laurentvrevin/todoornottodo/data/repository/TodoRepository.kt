package com.laurentvrevin.todoornottodo.data.repository

import com.laurentvrevin.todoornottodo.data.dao.TaskDao
import com.laurentvrevin.todoornottodo.data.model.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoRepository(private val taskDao: TaskDao) {
    val selectAll = taskDao.getAllTasks()

    suspend fun insertTodo(task: Task){
        withContext(Dispatchers.IO) {
            taskDao.insertTask(task)
        }
    }
    suspend fun deleteTodo(task: Task){
        withContext(Dispatchers.IO) {
            taskDao.deleteTask(task.id)
        }
    }
    suspend fun updateTodo(isCompleted:Boolean, id:Int){
        withContext(Dispatchers.IO) {
            taskDao.updateTask(isCompleted, id)
        }
    }

}