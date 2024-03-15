package com.laurentvrevin.todoornottodo.ui.presentation.screens


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todoornottodo.ui.activities.TaskViewState
import com.laurentvrevin.todoornottodo.ui.presentation.components.TaskCard
import com.laurentvrevin.todoornottodo.ui.presentation.viewmodels.TaskViewModel


@Composable
fun TaskListScreen(taskViewModel: TaskViewModel = hiltViewModel()) {

    val tasks by taskViewModel.tasksViewState.collectAsState(initial = emptyList())
    val sortedTaskEntities = tasks.sortedWith(compareBy<TaskViewState> { it.isChecked }.thenBy { it.creationDate })

    LazyColumn {
        items(sortedTaskEntities) { task ->
            TaskCard(
                taskViewState = task
            )
        }
    }
}

