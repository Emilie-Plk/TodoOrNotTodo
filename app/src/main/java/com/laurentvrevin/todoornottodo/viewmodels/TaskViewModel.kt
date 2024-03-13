package com.laurentvrevin.todoornottodo.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laurentvrevin.todoornottodo.data.model.TaskEntity
import com.laurentvrevin.todoornottodo.domain.model.TaskStatus
import com.laurentvrevin.todoornottodo.data.repository.TodoRepositoryImpl
import com.laurentvrevin.todoornottodo.domain.model.Task
import com.laurentvrevin.todoornottodo.domain.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel() {

    val tasks = repository.getAllTasks()


    var currentTask: Task? = null
    var showBottomSheet: Boolean by mutableStateOf(false)

    // Ajoute une tâche
    fun addTask(task: Task) {
        viewModelScope.launch {
            repository.insertTask(task)
        }
    }

    // Met à jour une tâche
    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

    // Supprime une tâche
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task.id)
        }
    }

    // Change le statut d'une tâche
    fun onTaskStatusChanged(task: Task, isDone: Boolean) {
        val newStatus = if (isDone) TaskStatus.DONE else TaskStatus.TO_DO
        val updatedTask = task.copy(status = newStatus)
        updateTask(updatedTask)
    }
}