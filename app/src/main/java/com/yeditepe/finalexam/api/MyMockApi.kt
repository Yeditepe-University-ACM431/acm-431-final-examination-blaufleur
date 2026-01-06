package com.yeditepe.finalexam.api

import com.yeditepe.finalexam.model.TaskDto

class MyMockApi : TaskApi {
    override suspend fun getTasks(): List<TaskDto> {
        return listOf(
            TaskDto(
                id = 1,
                title = "Task#1",
                completed = true
            ),
            TaskDto(
                id = 2,
                title = "Task#2",
                completed = false
            ),
            TaskDto(
                id = 3,
                title = "Task#3",
                completed = true
            ),
            TaskDto(
                id = 4,
                title = "Task#4",
                completed = false
            ),
            TaskDto(
                id = 5,
                title = "Task#5",
                completed = false
            ),
            TaskDto(
                id = 6,
                title = "Task#6",
                completed = false
            )
        )
    }
}