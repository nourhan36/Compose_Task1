package com.example.composetask1.ui.screens.issue_details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composetask1.R
import com.example.composetask1.ui.theme.ComposeTask1Theme
import com.example.composetask1.ui.theme.light_background
import com.example.composetask1.ui.theme.light_onBackground
import com.example.composetask1.ui.navigation.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController) {
    ComposeTask1Theme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Details", fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_back),
                                contentDescription = "Back Icon"
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = light_onBackground
                    )
                )
            }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .background(light_background)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_google),
                        contentDescription = "Google Logo",
                        modifier = Modifier
                            .size(120.dp)
                            .padding(bottom = 8.dp),
                        contentScale = ContentScale.Fit
                    )
                    Text(
                        text = "language",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        color = light_onBackground
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "1525",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = light_onBackground
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.ic_star),
                                contentDescription = "Star",
                                tint = Color.Yellow,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "Python",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = light_onBackground
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.ic_blue),
                                contentDescription = "Language Icon",
                                tint = Color.Blue,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "347",
                                fontWeight = FontWeight.Bold,
                                fontSize = 16.sp,
                                color = light_onBackground
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(
                                painter = painterResource(id = R.drawable.ic_repo),
                                contentDescription = "Fork",
                                tint = Color.Black,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Shared repository for open-sourced projects from the Google AI Language team.",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        color = light_onBackground,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
                Button(
                    onClick = { navController.navigate(Screens.IssueListScreen.route) },
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth(0.6f)
                        .height(50.dp),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)
                ) {
                    Text(text = "Show Issues", color = Color.White, fontSize = 18.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    val navController = rememberNavController()
    DetailsScreen(navController = navController)
}