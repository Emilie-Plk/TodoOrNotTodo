package com.laurentvrevin.todoornottodo.compose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laurentvrevin.todoornottodo.data.model.Task

@Composable
fun TaskInputForm(task: Task? = null, onAddTask: (Task) -> Unit, onEditTask: (Task) -> Unit) {
    // State for form fields
    var id by remember { mutableIntStateOf(0) }
    var title by remember { mutableStateOf(task?.title ?:"") }
    var description by remember { mutableStateOf(task?.description?:"") }
    var datetime by remember { mutableStateOf(task?.datetime?:"") }
    var deadline by remember { mutableStateOf(task?.deadline?:"") }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
        shadowElevation = 32.dp,
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                modifier = Modifier.padding(8.dp, 16.dp, 8.dp, 8.dp),
                value = title,
                onValueChange = { title = it },
                label = { Text("Title") }
            )
            TextField(
                modifier = Modifier.padding(8.dp),
                value = description,
                onValueChange = { description = it },
                label = { Text("Description") }
            )
            TextField(
                modifier = Modifier.padding(8.dp),
                value = datetime,
                onValueChange = { datetime = it },
                label = { Text("Date & Time") }
            )
            TextField(
                modifier = Modifier.padding(8.dp),
                value = deadline,
                onValueChange = { deadline = it },
                label = { Text("Deadline") }
            )
            Button(
                onClick = {
                    val taskToSubmit = (
                            Task(
                                title = title,
                                description = description,
                                datetime = datetime,
                                deadline = deadline,
                                id = id
                            )
                        )
                        // Reset fields after submission
                        title = ""
                        description = ""
                        datetime = ""
                        deadline = ""
                    if (task == null) {
                        onAddTask(taskToSubmit)
                    } else {
                        onEditTask?.invoke(task.copy(title=title, description = description, datetime = datetime, deadline = deadline))
                    }

                }
            ) {
                Text(if (task==null) "Add Task" else "Update Task")
            }
        }
    }
}

