package com.yeditepe.finalexam.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.yeditepe.finalexam.api.MyMockApi
import com.yeditepe.finalexam.repository.TaskRepository
import kotlin.reflect.KClass

class TaskViewModelFactory : ViewModelProvider.Factory {
    @Override
    override fun <T : ViewModel> create(modelClass: KClass<T>, extras: CreationExtras): T {
        return TaskViewModel(repository = extras[CreationExtras.Key<TaskRepository>()]!!) as T
    }
}