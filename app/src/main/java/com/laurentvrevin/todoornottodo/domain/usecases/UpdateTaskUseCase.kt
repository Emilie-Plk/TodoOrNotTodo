package com.laurentvrevin.todoornottodo.domain.usecases

import com.laurentvrevin.todoornottodo.domain.model.Task
import com.laurentvrevin.todoornottodo.domain.repository.TodoRepository
import javax.inject.Inject

class UpdateTaskUseCase @Inject constructor(private val todoRepository: TodoRepository) {
    suspend operator fun invoke(task: Task) {
        todoRepository.updateTask(task)
    }
}