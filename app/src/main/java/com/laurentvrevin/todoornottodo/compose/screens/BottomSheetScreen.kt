package com.laurentvrevin.todoornottodo.compose.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.laurentvrevin.todoornottodo.compose.components.CustomFloatingButton
import com.laurentvrevin.todoornottodo.data.model.Task
import com.laurentvrevin.todoornottodo.viewmodels.TaskViewModel

@Composable
fun BottomSheetScreen(taskViewModel: TaskViewModel = hiltViewModel(), onDismiss: () -> Unit) {

    
    var showBottomSheets by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(visible = !showBottomSheets) {
                CustomFloatingButton(
                    onClick = { showBottomSheets = true },
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                //background blanc quand bottomSheets ouvert et gris clair quand fermé
                .background(
                    if (showBottomSheets) Color.LightGray
                    else Color.White
                )
                // Pour faire disparaître la bottomSheets quand tu cliques à l'exterieur
                .clickable { showBottomSheets = false },
            verticalArrangement = Arrangement.Bottom,
        ) {
            AnimatedVisibility(visible = showBottomSheets) {
                TaskInputForm(
                    onAddTask = {task ->
                        taskViewModel.addTask(task)
                        showBottomSheets = false
                    },
                )
            }
        }
    }
}


@Preview
@Composable
fun BottomSheetsScreenPreview() {
    TaskInputForm(
        onAddTask = {},
    )
}