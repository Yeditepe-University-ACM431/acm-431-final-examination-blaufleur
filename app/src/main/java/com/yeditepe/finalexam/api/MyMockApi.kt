package com.yeditepe.finalexam.api

import com.yeditepe.finalexam.model.TaskDto

class MyMockApi : TaskApi {
    override suspend fun getTasks(): List<TaskDto> {
        return listOf(
            TaskDto(
                id = 1,
                title = "Task1",
                completed = true
            ),
            TaskDto(
                id = 2,
                title = "Task2",
                completed = false
            ),
            TaskDto(
                id = 3,
                title = "Task3",
                completed = true
            ),
            TaskDto(
                id = 4,
                title = "Task4",
                completed = false
            ),
            TaskDto(
                id = 5,
                title = "Task5",
                completed = false
            ),
            TaskDto(
                id = 6,
                title = "Task6",
                completed = false
            )
        )
    }
}