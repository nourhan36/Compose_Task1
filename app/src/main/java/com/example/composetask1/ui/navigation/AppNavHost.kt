package com.example.composetask1.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetask1.ui.screens.issue_list.IssueListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.IssueListScreen.route
    ) {
        composable(route = Screens.IssueListScreen.route) {
            IssueListScreen(onItemClick = {
                navController.navigate(Screens.IssueDetailsScreen.route)
            })


        }

        composable(route = Screens.IssueDetailsScreen.route) {

        }

    }

}