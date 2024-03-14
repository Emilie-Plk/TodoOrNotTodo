package com.laurentvrevin.todoornottodo.domain.usecases


import com.laurentvrevin.todoornottodo.domain.repository.TodoRepository
import javax.inject.Inject

class GetAllTasksUseCase @Inject constructor(private val todoRepository: TodoRepository) {
     operator fun invoke() = todoRepository.getAllTasks()
}
