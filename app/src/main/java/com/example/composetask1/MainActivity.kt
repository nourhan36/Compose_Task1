package com.example.composetask1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.composetask1.ui.navigation.AppNavHost
import com.example.composetask1.ui.theme.ComposeTask1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTask1Theme {
                AppNavHost()
            }
        }
    }
}