package com.laurentvrevin.todoornottodo.ui.presentation.components


import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration

import androidx.compose.ui.unit.dp
import com.laurentvrevin.todoornottodo.domain.model.TaskStatus
import com.laurentvrevin.todoornottodo.ui.activities.TaskViewState

@Composable
fun TaskCard(
    taskViewState: TaskViewState,
    modifier: Modifier = Modifier
) {
    val interactionSource = remember { MutableInteractionSource() }
    Card(
        modifier = modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ) { taskViewState.onTaskClicked }

    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = taskViewState.isChecked,
                        onCheckedChange = taskViewState.onCheckClicked,
                    )
                    Text(
                        text = taskViewState.title,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(start = 8.dp),
                        textDecoration = if (taskViewState.isChecked) TextDecoration.LineThrough else TextDecoration.None,
                        color =  if (taskViewState.isChecked) Color.LightGray else MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(Modifier.weight(1f))
                    IconButton(onClick = taskViewState.onEditClicked) {
                        Icon(Icons.Filled.Edit, contentDescription = "Edit")
                    }
                    IconButton(onClick = taskViewState.onDeleteClicked) {
                        Icon(Icons.Filled.Delete, contentDescription = "Delete")
                    }
                }

            }
            if (taskViewState.isExpandable) {
                Text(
                    text = taskViewState.description,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(top = 8.dp)
                )
            }

        }
    }
}

