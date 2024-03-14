package com.laurentvrevin.todoornottodo.presentation.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laurentvrevin.todoornottodo.domain.model.TaskStatus
import com.laurentvrevin.todoornottodo.domain.model.Task
import com.laurentvrevin.todoornottodo.domain.usecases.AddTaskUseCase
import com.laurentvrevin.todoornottodo.domain.usecases.DeleteTaskUseCase
import com.laurentvrevin.todoornottodo.domain.usecases.GetAllTasksUseCase
import com.laurentvrevin.todoornottodo.domain.usecases.UpdateTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase) : ViewModel() {

    val tasks = getAllTasksUseCase.invoke()
    var currentTask: Task? = null
    var showBottomSheet: Boolean by mutableStateOf(false)

    // Ajoute une tâche
    fun addTask(task: Task) {
        viewModelScope.launch {
            addTaskUseCase(task)
        }
    }

    // Met à jour une tâche
    fun updateTask(task: Task) {
        viewModelScope.launch {
           updateTaskUseCase(task)
        }
    }

    // Supprime une tâche
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            deleteTaskUseCase(task.id)
        }
    }

    // Change le statut d'une tâche
    fun onTaskStatusChanged(task: Task, isDone: Boolean) {
        val newStatus = if (isDone) TaskStatus.DONE else TaskStatus.TO_DO
        val updatedTask = task.copy(status = newStatus)
        updateTask(updatedTask)
    }
}