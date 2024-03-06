package com.laurentvrevin.todoornottodo.data.dao


import androidx.room.Dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.laurentvrevin.todoornottodo.data.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Query("DELETE from tasks WHERE id = :id")
    suspend fun deleteTask(id:Int)
    @Query("DELETE from tasks ")
    suspend fun deleteAllTasks()
}