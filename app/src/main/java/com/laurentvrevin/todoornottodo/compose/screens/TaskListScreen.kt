package com.laurentvrevin.todoornottodo.compose.screens


import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todoornottodo.compose.components.TaskCard
import com.laurentvrevin.todoornottodo.data.model.Task
import com.laurentvrevin.todoornottodo.viewmodels.TaskViewModel


@Composable
fun TaskListScreen(taskViewModel: TaskViewModel = hiltViewModel()) {
    // Ici, `tasks` pourrait être un LiveData ou un Flow que tu observes depuis ton ViewModel
    val tasks by taskViewModel.tasks.collectAsState(initial = emptyList())

    LazyColumn {
        items(tasks) { task ->
            TaskCard(task = task)
        }
    }
}

@Preview
@Composable
fun TasklistPreview(){
    TaskListScreen()
}
