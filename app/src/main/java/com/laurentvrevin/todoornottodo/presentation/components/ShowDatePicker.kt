package com.laurentvrevin.todoornottodo.presentation.components

import android.app.DatePickerDialog
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import java.util.Calendar
import java.util.Date

@Composable
fun ShowDatePicker(currentDate: Date, onDateSelected: (Date) -> Unit) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance().apply {
        time = currentDate
    }

    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    LaunchedEffect(Unit) {
        val datePickerDialog = DatePickerDialog(
            context, { _, year, month, dayOfMonth ->

                calendar.set(year, month, dayOfMonth)
                onDateSelected(calendar.time)
            }, year, month, day
        )

        datePickerDialog.show()
    }
}
