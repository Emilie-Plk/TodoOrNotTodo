package com.laurentvrevin.todoornottodo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.dp
import com.laurentvrevin.todoornottodo.presentation.components.CustomFloatingButton
import com.laurentvrevin.todoornottodo.domain.model.Task
import com.laurentvrevin.todoornottodo.domain.model.TaskPriority
import com.laurentvrevin.todoornottodo.domain.model.TaskStatus


import com.laurentvrevin.todoornottodo.presentation.viewmodels.TaskViewModel
import java.util.Date

@Composable
fun TaskBottomSheet(taskViewModel: TaskViewModel) {
    Box(modifier = Modifier.fillMaxSize()) {

        // Custom Floating Button
        CustomFloatingButton(
            onClick = {
                taskViewModel.currentTask = null
                taskViewModel.showBottomSheet = true
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp),
        )

        if (taskViewModel.showBottomSheet) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black.copy(alpha = 0.5f))
                    .clickable { taskViewModel.showBottomSheet = false }
            ) {

            }

            //
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp
                        )
                    )
                    .background(Color.White)
                    .padding(bottom = 16.dp)
            ) {
                TaskInputForm(
                    task = taskViewModel.currentTask ?: Task(
                        id = 0,
                        title = "",
                        description = "",
                        createDate = Date(),
                        deadline = Date(),
                        status = TaskStatus.TO_DO,
                        priority = TaskPriority.NORMAL
                    ),
                    onAddOrUpdateTask = { task ->
                        if (task.id == 0) {
                            taskViewModel.addTask(task)
                        } else {
                            taskViewModel.updateTask(task)
                        }
                        taskViewModel.showBottomSheet = false
                        taskViewModel.currentTask = null
                    }
                )
            }
        }
    }
}
