package com.yeditepe.finalexam.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yeditepe.finalexam.api.MyMockApi
import com.yeditepe.finalexam.repository.TaskRepository

class TaskViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val repository = TaskRepository(MyMockApi())
        return TaskViewModel(repository) as T
    }
}