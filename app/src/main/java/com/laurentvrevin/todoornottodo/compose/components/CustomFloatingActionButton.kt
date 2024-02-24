package com.laurentvrevin.todoornottodo.compose.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun MonFloatingActionButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary,
    shape: Shape = FloatingActionButtonDefaults.shape
    ) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier,
        containerColor = backgroundColor,
        shape = shape
    ) {
        Icon(Icons.Filled.Add, contentDescription = "Ajouter")
    }

}
@Preview
@Composable
fun PreviewMFAB() {
    MonFloatingActionButton(
        onClick = {},
        modifier = Modifier.padding(16.dp),

        shape =  RoundedCornerShape(10.dp)
    )


}