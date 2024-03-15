package com.laurentvrevin.todoornottodo.ui.activities

import androidx.annotation.ColorRes
import java.util.Date

// Modele de la vue
data class TaskViewState(
    val id : Int,
    val title: String,
    val description: String,
    val isExpandable: Boolean,
    val creationDate: Date,
    val status: String,
    @ColorRes val priority: Int,
    val isChecked: Boolean,
    val onTaskClicked: () -> Unit,
    val onEditClicked: () -> Unit,
    val onCheckClicked: (Boolean) -> Unit,
    val onDeleteClicked: () -> Unit,
)
