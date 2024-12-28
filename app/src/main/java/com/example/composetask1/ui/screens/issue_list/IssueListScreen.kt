package com.example.composetask1.ui.screens.issue_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.composetask1.ui.screens.issue_list.preview.fakeRepoList

@Composable
fun IssueListScreen(
    onItemClick: () -> Unit
) {
    LazyColumn(
        Modifier.fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        items(fakeRepoList){ issueItem ->
            IssueItem(
                githubIssueUiModel = issueItem,
                onItemClick = onItemClick
            )
        }
    }
}