package com.laurentvrevin.todoornottodo.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todoornottodo.viewmodels.TaskViewModel
import com.laurentvrevin.todoornottodo.compose.components.MonFloatingActionButton
import com.laurentvrevin.todoornottodo.compose.screens.BottomSheetScreen
import com.laurentvrevin.todoornottodo.compose.screens.TaskInputForm
import com.laurentvrevin.todoornottodo.data.model.Task
import com.laurentvrevin.todoornottodo.ui.theme.TodoOrNotTodoTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoOrNotTodoTheme {
                //MainScreen()
                BottomSheetScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val taskViewModel: TaskViewModel = hiltViewModel()
    var showTaskInput by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            MonFloatingActionButton(onClick = { showTaskInput = true })
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.Green)
        ) {
            if (showTaskInput) {
                ShowFullDialog(
                    onDismissRequest = { showTaskInput = false },
                    onAddTask = { task ->
                    taskViewModel.addTask(task)
                    showTaskInput = false
                })
            } else {
                Greeting("Android")
            }
        }
    }
}
@Composable
fun ShowFullDialog(onDismissRequest: () -> Unit, onAddTask: (Task) -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        TaskInputForm(onAddTask = onAddTask)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TodoOrNotTodoTheme {
        Greeting("Android")
    }
}