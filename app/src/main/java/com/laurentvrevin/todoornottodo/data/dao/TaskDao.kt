package com.laurentvrevin.todoornottodo.data.dao


import androidx.room.Dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.laurentvrevin.todoornottodo.data.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<Task>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: Task)

    @Query("UPDATE tasks SET isComplete = :isComplete WHERE id = :id")
    suspend fun updateTask(isComplete:Boolean, id:Int)

    @Query("DELETE from tasks WHERE id = :id")
    suspend fun deleteTask(id:Int)
    @Query("DELETE from tasks ")
    suspend fun deleteAllTasks()
}