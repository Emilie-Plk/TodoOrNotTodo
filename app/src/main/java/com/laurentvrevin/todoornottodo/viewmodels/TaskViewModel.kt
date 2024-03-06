package com.laurentvrevin.todoornottodo.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laurentvrevin.todoornottodo.data.model.Task
import com.laurentvrevin.todoornottodo.data.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val repository: TodoRepository) : ViewModel(){
    val tasks = repository.selectAll
    var currentTask: Task? by mutableStateOf(null)
    var showBottomSheet: Boolean by mutableStateOf(false)

    //add a task
    fun addTask(task: Task){
        viewModelScope.launch{
            repository.insertTodo(task)
        }
    }
    fun updateTask(task:Task){
        viewModelScope.launch {
            repository.updateTodo(task)
        }
    }
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTodo(task)
        }
    }
}