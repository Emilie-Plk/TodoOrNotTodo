package com.laurentvrevin.todoornottodo.di

import com.laurentvrevin.todoornottodo.data.dao.TaskDao
import com.laurentvrevin.todoornottodo.data.repository.TodoRepositoryImpl
import com.laurentvrevin.todoornottodo.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideTodoRepository(taskDao: TaskDao): TodoRepository {
        return TodoRepositoryImpl(taskDao)
    }
}