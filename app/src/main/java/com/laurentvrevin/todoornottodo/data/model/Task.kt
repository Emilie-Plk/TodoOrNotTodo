package com.laurentvrevin.todoornottodo.data.model


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import java.util.Date


@Entity(tableName = "tasks")
data class Task (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "description") val description:String,
    @ColumnInfo(name = "datetime") val createDate: Date = Date(),
    @ColumnInfo(name = "deadline") val deadline:Date,
    @ColumnInfo(name = "status") val status: TaskStatus,
    @ColumnInfo(name = "priority") val priority: TaskPriority,
    @ColumnInfo(name = "order") val order: Int? = null
) {

}
