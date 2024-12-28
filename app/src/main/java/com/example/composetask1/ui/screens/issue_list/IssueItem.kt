package com.example.composetask1.ui.screens.issue_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetask1.R
import com.example.composetask1.ui.screens.issue_list.preview.fakeRepoList
import com.example.composetask1.ui.theme.ComposeTask1Theme

@Composable
fun IssueItem(
    githubIssueUiModel: GithubIssueUiModel,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit
) {
    Row(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 8.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = MaterialTheme.shapes.medium
            )
            .clickable {
                onItemClick()
            }
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .padding(top = 8.dp, start = 8.dp)
                .clip(shape = CircleShape),
            painter = painterResource(R.drawable.ic),
            contentDescription = "Logo"
        )

        Column(
            Modifier
                .padding(horizontal = 8.dp, vertical = 8.dp)
                .weight(1f)
        ) {
            Row(
                Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = githubIssueUiModel.title,
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = githubIssueUiModel.status,
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            Spacer(Modifier.height(8.dp))

            Text(
                text = githubIssueUiModel.subtitle,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = githubIssueUiModel.createdAt,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF0F0F0)
@Composable
fun PreviewIssueItem() {
    ComposeTask1Theme{
        IssueItem(githubIssueUiModel = fakeRepoList.first(), onItemClick = {})
    }
}