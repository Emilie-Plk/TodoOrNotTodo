package com.laurentvrevin.todoornottodo.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.laurentvrevin.todoornottodo.ui.components.MonFloatingActionButton
import com.laurentvrevin.todoornottodo.ui.screens.TaskInputForm
import com.laurentvrevin.todoornottodo.ui.theme.TodoOrNotTodoTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoOrNotTodoTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showTaskInput by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            MonFloatingActionButton(onClick = { showTaskInput = !showTaskInput })
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            color = MaterialTheme.colorScheme.background
        ) {
            if (showTaskInput) {
                ModalBottomSheet(
                    onDismissRequest = {
                        showTaskInput = false
                                       },
                    sheetState = sheetState
                ) {
                    TaskInputForm(onAddTask = { task ->
                        // add task here
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible){
                                showTaskInput = false
                            }
                        }
                        showTaskInput = false // Hide TaskInputForm w/ BottomSheet
                    })
                }

            }
            else {
                Greeting("Android")
            }
        }
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