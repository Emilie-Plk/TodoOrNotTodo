package com.laurentvrevin.todoornottodo.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.laurentvrevin.todoornottodo.compose.components.CustomFloatingButton
import com.laurentvrevin.todoornottodo.viewmodels.TaskViewModel

@Composable
fun TaskBottomSheet(taskViewModel: TaskViewModel) {
    var showBottomSheet by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        CustomFloatingButton(
            onClick = { showBottomSheet = !showBottomSheet },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        )

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
                    .background(Color.White)

            ) {
                TaskInputForm(onAddTask = { task ->
                    taskViewModel.addTask(task)
                    showBottomSheet = false
                })
            }
        }
    }
}