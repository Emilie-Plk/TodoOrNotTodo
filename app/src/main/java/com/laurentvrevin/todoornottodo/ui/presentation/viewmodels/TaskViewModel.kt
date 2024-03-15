package com.laurentvrevin.todoornottodo.ui.presentation.viewmodels


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laurentvrevin.todoornottodo.R
import com.laurentvrevin.todoornottodo.domain.model.Task
import com.laurentvrevin.todoornottodo.domain.model.TaskPriority
import com.laurentvrevin.todoornottodo.domain.model.TaskStatus
import com.laurentvrevin.todoornottodo.domain.usecases.AddTaskUseCase
import com.laurentvrevin.todoornottodo.domain.usecases.DeleteTaskUseCase
import com.laurentvrevin.todoornottodo.domain.usecases.GetAllTasksUseCase
import com.laurentvrevin.todoornottodo.domain.usecases.UpdateTaskUseCase
import com.laurentvrevin.todoornottodo.ui.activities.TaskViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getAllTasksUseCase: GetAllTasksUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {

    val tasksViewState: Flow<List<TaskViewState>> = getAllTasksUseCase.invoke().map {
        it.map { task ->
            TaskViewState(
                id = task.id,
                title = task.title,
                description = task.description,
                isExpandable = task.description.isNotBlank(),
                creationDate = task.createDate,
                status = when (task.status) {
                    TaskStatus.TO_DO -> "To do"
                    TaskStatus.DONE -> "Done"
                },
                priority = when (task.priority) {
                    TaskPriority.LOW -> R.color.black
                    TaskPriority.HIGH -> R.color.purple_200
                    TaskPriority.NORMAL -> R.color.teal_200
                },
                isChecked = task.status == TaskStatus.DONE,
                onTaskClicked = {
                    currentTask = task
                    showBottomSheet = true
                },
                onEditClicked = {
                    viewModelScope.launch {
                        updateTaskUseCase(task)
                    }
                },
                onCheckClicked = { isChecked ->
                    viewModelScope.launch {
                        val newStatus = if (isChecked) TaskStatus.DONE else TaskStatus.TO_DO
                        updateTaskUseCase(task.copy(status = newStatus))
                    }
                },
                onDeleteClicked = {
                    viewModelScope.launch {
                        deleteTaskUseCase.invoke(task.id)
                    }
                }
            )
        }
    }

    var currentTask: Task? = null  // TODO: hu?
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

}