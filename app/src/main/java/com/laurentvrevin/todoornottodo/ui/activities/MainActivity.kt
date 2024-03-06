package com.laurentvrevin.todoornottodo.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth


import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold



import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todoornottodo.compose.screens.TaskBottomSheet
import com.laurentvrevin.todoornottodo.viewmodels.TaskViewModel

import com.laurentvrevin.todoornottodo.compose.screens.TaskInputForm
import com.laurentvrevin.todoornottodo.compose.screens.TaskListScreen

import com.laurentvrevin.todoornottodo.ui.theme.TodoOrNotTodoTheme
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




