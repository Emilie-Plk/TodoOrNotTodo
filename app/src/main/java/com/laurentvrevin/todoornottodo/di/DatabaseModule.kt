package com.laurentvrevin.todoornottodo.di

import android.content.Context
import androidx.room.Room
import com.laurentvrevin.todoornottodo.data.dao.TaskDao
import com.laurentvrevin.todoornottodo.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AppDatabase {

        return Room.databaseBuilder(appContext, AppDatabase::class.java, "todo_database").build()
    }


    @Provides
    fun provideTaskDao(database: AppDatabase): TaskDao = database.taskDao()
}