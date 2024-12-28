package com.example.composetask1.ui.navigation

sealed class Screens(val route : String) {
    data object IssueListScreen : Screens("issue_list")
    data object IssueDetailsScreen : Screens("issue_details")
}