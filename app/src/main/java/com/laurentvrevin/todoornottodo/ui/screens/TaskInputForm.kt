package com.laurentvrevin.todoornottodo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.laurentvrevin.todoornottodo.data.model.Task

@Composable
fun TaskInputForm(onAddTask: (Task) -> Unit) {
    // State for form fields
    var id by remember { mutableIntStateOf(0) }
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var datetime by remember { mutableStateOf("") }
    var deadline by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") }
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") }
        )
        TextField(
            value = datetime,
            onValueChange = { datetime = it },
            label = { Text("Date & Time") }
        )
        TextField(
            value = deadline,
            onValueChange = { deadline = it },
            label = { Text("Deadline") }
        )
        Button(
            onClick = {
                onAddTask(Task(
                    title = title,
                    description = description,
                    datetime = datetime,
                    deadline = deadline,
                    id = id
                ))
                // Reset fields after submission
                title = ""
                description = ""
                datetime = ""
                deadline = ""
            }
        ) {
            Text("Add Task")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun TaskInputFormPreview() {
    TaskInputForm(onAddTask = { /* Exemple d'action, peut rester vide pour la prévisualisation */ })
}
