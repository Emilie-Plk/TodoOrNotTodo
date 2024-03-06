package com.laurentvrevin.todoornottodo.compose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import com.laurentvrevin.todoornottodo.data.model.Task

@Composable
fun TaskCard(task: Task, onEdit: () -> Unit, onDelete: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f) // Prend l'espace disponible mais laisse de la place pour les boutons
            ) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = task.description,
                    style = MaterialTheme.typography.bodyMedium
                )
               /* Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = task.datetime,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = task.deadline,
                    style = MaterialTheme.typography.bodySmall
                )*/
            }
            // Cette colonne n'a pas besoin de Modifier.fillMaxWidth()
            Column(
                horizontalAlignment = Alignment.End
            ) {
                IconButton(onClick = {onEdit()}) {
                    Icon(Icons.Filled.Edit, contentDescription = "Edit")
                }
                IconButton(onClick = onDelete) {
                    Icon(Icons.Filled.Delete, contentDescription = "Delete")
                }
            }
        }
    }
}
@Preview
@Composable
fun taskCarPreview(){
    TaskCard(task = Task(1, "titre", "desc","date", "deadline"), onEdit = {}, onDelete = {} )
}
