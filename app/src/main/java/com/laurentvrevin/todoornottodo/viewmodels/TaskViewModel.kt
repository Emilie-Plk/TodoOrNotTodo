package com.laurentvrevin.todoornottodo.viewmodels

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

    //add a task
    fun addTask(task: Task){
        viewModelScope.launch{
            repository.insertTodo(task)
        }
    }
}