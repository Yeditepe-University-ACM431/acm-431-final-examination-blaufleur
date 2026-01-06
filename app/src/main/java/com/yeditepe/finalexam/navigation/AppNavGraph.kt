package com.yeditepe.finalexam.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgs
import androidx.navigation.NavArgument
import androidx.navigation.NavArgumentBuilder
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yeditepe.finalexam.ui.TaskListScreen

@Composable
fun AppNavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "tasks"
    ) {

        // TODO 1: Add composable for "tasks"
        composable(route = "tasks") {
            TaskListScreen()
        }

        // TODO 2: Add composable for "taskDetail/{title}"
        composable(
            route = "taskDetail/{title}"
        ) { navBackStackEntry ->
            val title = navBackStackEntry.arguments?.getString("title") ?: ""
        }
    }
}
