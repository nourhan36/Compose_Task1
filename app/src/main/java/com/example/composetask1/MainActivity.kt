package com.example.composetask1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetask1.ui.theme.ComposeTask1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTask1Theme {
                IssuesScreen()
            }
        }
    }
}

@Composable
fun IssuesScreen() {
    val issues = listOf(
        Issue("Bump pyarrow", "NONE", "2023-11-9, 23:00 PM", "Open"),
        Issue("Français", "NONE", "2023-11-2, 9:38 AM", "Open"),
        Issue("Bump werkzeug", "NONE", "2023-10-25, 18:52 PM", "Open"),
        Issue("Bump urllib3 from", "NONE", "2023-10-17, 22:59 PM", "Open"),
        Issue("ORQA fine tuning with", "NONE", "2023-10-9, 15:3 PM", "Open"),
        Issue("Bump pillow from", "NONE", "2023-10-4, 0:35 AM", "Open")
    )

    Scaffold { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(top = 4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            items(issues.size) { index ->
                IssueCard(issues[index])
            }
        }
    }
}


@Composable
fun IssueCard(issue: Issue) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 8.dp, start = 8.dp)
                    .clip(shape = CircleShape)
                    .background(
                        color = Color.White
                    )
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = issue.title,
                        style = MaterialTheme.typography.bodyLarge,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = issue.status,
                        style = MaterialTheme.typography.bodyMedium,
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = issue.subtitle,
                    style = MaterialTheme.typography.labelSmall,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = issue.createdAt,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}


data class Issue(
    val title: String,
    val subtitle: String,
    val createdAt: String,
    val status: String
)

@Preview(showBackground = true)
@Composable
fun PreviewIssuesScreen() {
    ComposeTask1Theme {
        IssuesScreen()
    }
}
