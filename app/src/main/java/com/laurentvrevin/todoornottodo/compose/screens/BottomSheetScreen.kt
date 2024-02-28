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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
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
import com.laurentvrevin.todoornottodo.compose.components.MonFloatingActionButton

@Composable
fun BottomSheetScreen() {

    var showBottomSheets by remember { mutableStateOf(false) }

    Scaffold(
        floatingActionButton = {
            AnimatedVisibility(visible = !showBottomSheets) {
                MonFloatingActionButton(
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
                BottomSheets(
                    onAddButtonClicked = { showBottomSheets = false },
                )
            }
        }
    }
}

@Composable
fun BottomSheets(
    onAddButtonClicked: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp, 15.dp, 15.dp, 0.dp)),
        shadowElevation = 32.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TextField(
                modifier = Modifier.padding(8.dp, 24.dp, 8.dp, 8.dp),
                value = "",
                onValueChange = { /* todo */ },
                label = { Text("Title") },
            )
            TextField(
                modifier = Modifier.padding(8.dp),
                value = "",
                onValueChange = { /* todo */ },
                label = { Text("Description") },
            )
            TextField(
                modifier = Modifier.padding(8.dp),
                value = "",
                onValueChange = { /* todo */ },
                label = { Text("Date & Time") },
            )
            TextField(
                modifier = Modifier.padding(8.dp),
                value = "",
                onValueChange = { /* todo */ },
                label = { Text("Deadline") },
            )
            Button(
                modifier = Modifier.padding(8.dp, 8.dp, 16.dp, 8.dp),
                onClick = onAddButtonClicked,
            ) {
                Text("Add Task")
            }
        }
    }
}

@Preview
@Composable
fun BottomSheetsScreenPreview() {
    BottomSheets(
        onAddButtonClicked = {},
    )
}