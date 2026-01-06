package com.yeditepe.finalexam.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgs
import androidx.navigation.NavArgument
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yeditepe.finalexam.api.MyMockApi
import com.yeditepe.finalexam.repository.TaskRepository
import com.yeditepe.finalexam.ui.TaskDetailScreen
import com.yeditepe.finalexam.ui.TaskListScreen
import com.yeditepe.finalexam.viewmodel.TaskViewModel
import com.yeditepe.finalexam.viewmodel.TaskViewModelFactory

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "tasks"
    ) {

        // TODO 1: Add composable for "tasks"
        composable(route = "tasks") {
            val viewModel: TaskViewModel = viewModel(factory = TaskViewModelFactory())
            TaskListScreen(viewModel, navController)
        }

        // TODO 2: Add composable for "taskDetail/{title}"
        composable(
            route = "taskDetail/{title}",
            arguments = listOf(
                navArgument("title") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val title = navBackStackEntry.arguments?.getString("title") ?: ""
            TaskDetailScreen(title)
        }
    }
}
