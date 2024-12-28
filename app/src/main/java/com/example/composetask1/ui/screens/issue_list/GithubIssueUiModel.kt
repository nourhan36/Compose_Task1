package com.example.composetask1.ui.screens.issue_list

data class GithubIssueUiModel(
    val id: Int,
    val title: String,
    val subtitle: String,
    val createdAt: String,
    val status: String
)
