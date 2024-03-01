package com.laurentvrevin.todoornottodo.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todoornottodo.viewmodels.TaskViewModel
import com.laurentvrevin.todoornottodo.compose.components.CustomFloatingButton
import com.laurentvrevin.todoornottodo.compose.screens.BottomSheetScreen
import com.laurentvrevin.todoornottodo.compose.screens.TaskListScreen

import com.laurentvrevin.todoornottodo.ui.theme.TodoOrNotTodoTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoOrNotTodoTheme {
                MainContent()
                TaskListScreen()
            }
        }
    }
}

@Composable
fun MainContent() {
    // État pour contrôler l'affichage de la Bottom Sheet
    var showBottomSheet by remember { mutableStateOf(false) }
    val taskViewModel: TaskViewModel = hiltViewModel()

    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(visible = !showBottomSheet) {
                CustomFloatingButton(onClick = { showBottomSheet = true })
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (showBottomSheet) {
                BottomSheetScreen(
                    taskViewModel = taskViewModel,
                    onDismiss = { showBottomSheet = false }
                )
            }
        }
    }
}


