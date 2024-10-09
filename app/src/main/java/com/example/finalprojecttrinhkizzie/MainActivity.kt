package com.example.finalprojecttrinhkizzie

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalprojecttrinhkizzie.ui.theme.AppTheme
import com.example.finalprojecttrinhkizzie.ui.theme.FinalProjectTrinhKizzieTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GetStartedScreen(onGetStartedClick = {
                        startActivity(Intent(this, TaskTypeSelectionActivity::class.java))
                    })
                }
            }
        }
    }
}

@Composable
fun GetStartedScreen(onGetStartedClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Welcome to Simple To Do App",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onGetStartedClick) {
            Text("Get Started")
        }
    }
}