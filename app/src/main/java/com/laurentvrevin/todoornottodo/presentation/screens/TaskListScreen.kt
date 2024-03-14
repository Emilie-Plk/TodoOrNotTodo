package com.laurentvrevin.todoornottodo.presentation.screens


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todoornottodo.presentation.components.TaskCard
import com.laurentvrevin.todoornottodo.domain.model.Task
import com.laurentvrevin.todoornottodo.domain.model.TaskStatus

import com.laurentvrevin.todoornottodo.presentation.viewmodels.TaskViewModel


@Composable
fun TaskListScreen(taskViewModel: TaskViewModel = hiltViewModel()) {

    val tasks by taskViewModel.tasks.collectAsState(initial = emptyList())
    val sortedTaskEntities = tasks.sortedWith(compareBy<Task> { it.status == TaskStatus.DONE }.thenBy { it.createDate })

    LazyColumn {
        items(sortedTaskEntities) { task ->
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

