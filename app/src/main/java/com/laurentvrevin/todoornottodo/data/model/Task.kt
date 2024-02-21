package com.laurentvrevin.todoornottodo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Int=0,
    @ColumnInfo(name = "title") val title:String,
    @ColumnInfo(name = "description") val description:String,
    @ColumnInfo(name = "datetime") val datetime:String,
    @ColumnInfo(name = "deadline") val deadline:String,
    @ColumnInfo(name = "isComplete") val isComplete:Boolean=false
)
