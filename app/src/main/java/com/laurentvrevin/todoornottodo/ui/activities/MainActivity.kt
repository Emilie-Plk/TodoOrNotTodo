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

@Composable
fun MainContent() {
    // État pour contrôler l'affichage de la Bottom Sheet
    var showBottomSheet by remember { mutableStateOf(false) }
    val taskViewModel: TaskViewModel = hiltViewModel()

    Box(modifier = Modifier.fillMaxSize()) {
        TaskListScreen(taskViewModel = taskViewModel)
        FloatingActionButton(
            onClick = { showBottomSheet = !showBottomSheet },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )
        {
            Icon(Icons.Filled.Add, contentDescription = "Add")
        }
        // Zone transparente pour détecter les clics en dehors de la Bottom Sheet
        if (showBottomSheet) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable { showBottomSheet = false }
            ) {
                // Prevent clicks through the box
            }

            // Contenu de la Bottom Sheet positionné en bas
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White) // Utilise la couleur de ton choix ici
                    .clickable { } // Absorbe les clics pour éviter la fermeture par le Box derrière
            ) {
                TaskInputForm(onAddTask = { task ->
                    taskViewModel.addTask(task)
                    showBottomSheet = false
                })
            }
        }
    }
}


