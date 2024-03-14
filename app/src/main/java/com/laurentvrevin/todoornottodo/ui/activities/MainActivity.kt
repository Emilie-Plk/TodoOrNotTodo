package com.laurentvrevin.todoornottodo.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent


import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todoornottodo.presentation.screens.TaskBottomSheet
import com.laurentvrevin.todoornottodo.presentation.viewmodels.TaskViewModel

import com.laurentvrevin.todoornottodo.presentation.screens.TaskListScreen

import com.laurentvrevin.todoornottodo.presentation.theme.TodoOrNotTodoTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoOrNotTodoTheme {
                val taskViewModel: TaskViewModel = hiltViewModel()

                // Affiche la liste des tâches
                TaskListScreen(taskViewModel = taskViewModel)

                // Composant pour créer de nouvelles tâches
                TaskBottomSheet(taskViewModel = taskViewModel)

            }
        }
    }
}




