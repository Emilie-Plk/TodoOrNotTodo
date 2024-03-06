package com.laurentvrevin.todoornottodo.compose.screens

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.laurentvrevin.todoornottodo.compose.components.CustomFloatingButton
import com.laurentvrevin.todoornottodo.data.model.Task
import com.laurentvrevin.todoornottodo.viewmodels.TaskViewModel

@Composable
fun TaskBottomSheet(taskViewModel: TaskViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {

        //Custom Floating Button
        CustomFloatingButton(
            onClick = {
                // Réinitialiser currentTask pour créer une nouvelle tâche
                taskViewModel.currentTask = null
                taskViewModel.showBottomSheet = true
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
        )

        //Make a little dark box max screen size
        if (taskViewModel.showBottomSheet) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { taskViewModel.showBottomSheet = false }
            ) {
                // Prevent clicks through the box
            }

            //Make a box with my bottomsheet inside
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .wrapContentHeight()
            )
            //My bottomsheet take the TaskInputForm inside
            {
            TaskInputForm(
                task = taskViewModel.currentTask,
                onAddTask = { newTask ->
                    taskViewModel.addTask(newTask)
                    taskViewModel.showBottomSheet = false
                    taskViewModel.currentTask = null
                },
                onEditTask = { updatedTask ->
                    if (taskViewModel.currentTask != null) {
                        taskViewModel.updateTask(updatedTask)
                    }
                    taskViewModel.showBottomSheet = false
                    taskViewModel.currentTask = null
                }
            )
            }
        }
    }
}
