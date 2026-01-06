package com.yeditepe.finalexam.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yeditepe.finalexam.model.Task
import com.yeditepe.finalexam.repository.TaskRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TaskViewModel(
    private val repository: TaskRepository
) : ViewModel() {

    // TODO 1: Create a mutable state list of Task objects
    // Initially add at least 2 tasks
    private val _state = MutableStateFlow(listOf(
        Task(
            id = 1,
            title = "First Task",
            isCompleted = false
        ),
        Task(
            id = 2,
            title = "Second Task",
            isCompleted = false
        )
    ))

    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            _state.value = repository.fetchTasks()
        }
    }

    fun toggleTask(taskId: Int) {
        // TODO 2: Update isCompleted for the given task
        val task = _state.value.find { t ->
            t.id == taskId
        } ?: return

        task.isCompleted = !task.isCompleted
    }
}
