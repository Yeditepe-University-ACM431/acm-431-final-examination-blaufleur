package com.yeditepe.finalexam.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.yeditepe.finalexam.model.Task
import com.yeditepe.finalexam.ui.theme.MyApplicationTheme
import com.yeditepe.finalexam.viewmodel.TaskViewModel

@Composable
fun TaskListScreen(viewModel: TaskViewModel = viewModel()) {

    // TODO 3: Read task list from ViewModel
    val state = viewModel.state.collectAsState()

    Column {
        // TODO 4: Display task titles and completion status
        // Use a simple Column or LazyColumn
        LazyColumn {
            items(state.value) { t ->
                Card (modifier = Modifier.padding(8.dp)) {
                    Text(text = t.title)
                    Text(text = "Completed: ${t.isCompleted}")
                }
            }
        }
    }
}

@Composable
fun TaskRow(task: Task, navController: NavController) {

    Text(
        text = task.title,
        modifier = Modifier.clickable {
            // TODO 3: Navigate to detail screen with task title
            navController.navigate("taskDetail/${task.title}")
        }
    )
}

@Preview
@Composable
fun TaskListScreenPreview() {
    MyApplicationTheme {
        TaskListScreen()
    }
}
