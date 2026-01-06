package com.yeditepe.finalexam.viewmodel

import androidx.lifecycle.ViewModel
import com.yeditepe.finalexam.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TaskViewModel : ViewModel() {

    // TODO 1: Create a mutable state list of Task objects
    // Initially add at least 2 tasks
    private val _state = MutableStateFlow<List<Task>>(listOf(
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

    fun toggleTask(taskId: Int) {
        // TODO 2: Update isCompleted for the given task
        val task = _state.value.find { t ->
            t.id == taskId
        } ?: return

        task.isCompleted = !task.isCompleted
    }
}
