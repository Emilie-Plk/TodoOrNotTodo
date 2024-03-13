package com.laurentvrevin.todoornottodo.compose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laurentvrevin.todoornottodo.compose.components.PrioritySelector
import com.laurentvrevin.todoornottodo.compose.components.ShowDatePicker
import com.laurentvrevin.todoornottodo.compose.components.StatusSelector
import com.laurentvrevin.todoornottodo.domain.model.Task
import com.laurentvrevin.todoornottodo.domain.model.TaskPriority
import com.laurentvrevin.todoornottodo.domain.model.TaskStatus
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun TaskInputForm(task: Task, onAddOrUpdateTask: (Task) -> Unit) {
    // Format pour la conversion de Date en String et vice-versa
    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    var selectedDate by remember { mutableStateOf(task?.deadline ?: Date()) }

    var title by remember { mutableStateOf(task?.title ?: "") }
    var description by remember { mutableStateOf(task?.description ?: "") }
    var deadlineString by remember { mutableStateOf(task?.deadline?.let { dateFormat.format(it) } ?: "") }
    var status by remember { mutableStateOf(task?.status ?: TaskStatus.TO_DO) }
    var priority by remember { mutableStateOf(task?.priority ?: TaskPriority.NORMAL) }
    var showDatePicker by remember { mutableStateOf(false) }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.White)
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                modifier = Modifier.padding(8.dp),
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") }
            )
            TextField(
                modifier = Modifier
                    .padding(8.dp)
                    .heightIn(100.dp),
                maxLines = 5,
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") }
            )
            // Bouton pour ouvrir le DatePicker
            OutlinedButton(
                onClick = { showDatePicker = true }
            ) {
                Text(text = if (deadlineString.isEmpty()) "Select Deadline" else deadlineString)
            }
            if (showDatePicker) {
                ShowDatePicker(currentDate = selectedDate) {date ->
                    selectedDate = date
                    showDatePicker = false
                }
            }

            // Sélecteurs pour le statut et la priorité
            StatusSelector(status = status, onStatusSelected = { status = it })
            PrioritySelector(priority = priority, onPrioritySelected = { priority = it })

            Button(
                onClick = {
                    val newOrUpdatedTask = task.copy(
                        title = title,
                        description = description,
                        deadline = selectedDate,
                        status = status,
                        priority = priority
                    ) ?: Task(
                        title = title,
                        description = description,
                        createDate = Date(),
                        deadline = selectedDate,
                        status = status,
                        priority = priority
                    )
                    onAddOrUpdateTask(newOrUpdatedTask)
                }
            )  {
                Text(text = if (task == null) "Add Task" else "Update Task")
            }
        }
    }
}
@Preview
@Composable
fun previewTaskInputForm(){

}


