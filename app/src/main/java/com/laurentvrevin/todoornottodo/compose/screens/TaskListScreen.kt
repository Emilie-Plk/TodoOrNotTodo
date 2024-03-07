package com.laurentvrevin.todoornottodo.compose.screens


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todoornottodo.compose.components.TaskCard
import com.laurentvrevin.todoornottodo.data.model.Task
import com.laurentvrevin.todoornottodo.data.model.TaskStatus

import com.laurentvrevin.todoornottodo.viewmodels.TaskViewModel


@Composable
fun TaskListScreen(taskViewModel: TaskViewModel = hiltViewModel()) {

    val tasks by taskViewModel.tasks.collectAsState(initial = emptyList())
    val sortedTasks = tasks.sortedWith(compareBy<Task> { it.status == TaskStatus.DONE }.thenBy { it.createDate })

    LazyColumn {
        items(sortedTasks) { task ->
            TaskCard(
                task = task,
                onEdit = {
                    taskViewModel.currentTask = task
                    taskViewModel.showBottomSheet = true
                },
                onDelete = { taskViewModel.deleteTask(task) },
                onToggleDone = { task, isDone -> taskViewModel.onTaskStatusChanged(task, isDone) }
            )
        }
    }
}

