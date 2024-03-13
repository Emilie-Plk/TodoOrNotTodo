package com.laurentvrevin.todoornottodo.compose.components

import androidx.compose.runtime.Composable
import com.laurentvrevin.todoornottodo.domain.model.TaskStatus

@Composable
fun StatusSelector(status: TaskStatus, onStatusSelected: (TaskStatus) -> Unit) {
    // To see later
}