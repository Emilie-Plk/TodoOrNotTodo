package com.laurentvrevin.todoornottodo.data.entities


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import java.util.Date


@Entity(tableName = "tasks")
data class TaskEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "description") val description:String,
    @ColumnInfo(name = "datetime") val createDate: Date = Date(),
    @ColumnInfo(name = "deadline") val deadline:Date,
    @ColumnInfo(name = "status") val status: String,
    @ColumnInfo(name = "priority") val priority: String,
    @ColumnInfo(name = "order") val order: Int? = null
)
