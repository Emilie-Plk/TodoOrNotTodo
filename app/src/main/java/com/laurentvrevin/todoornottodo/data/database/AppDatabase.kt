package com.laurentvrevin.todoornottodo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.laurentvrevin.todoornottodo.data.dao.TaskDao
import com.laurentvrevin.todoornottodo.data.model.Task
import com.laurentvrevin.todoornottodo.utils.Converters

@Database(entities = [Task::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao

}