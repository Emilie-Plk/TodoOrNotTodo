package com.laurentvrevin.todoornottodo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.laurentvrevin.todoornottodo.data.dao.TaskDao
import com.laurentvrevin.todoornottodo.data.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao

}