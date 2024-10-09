package com.example.finalprojecttrinhkizzie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.finalprojecttrinhkizzie.ui.theme.FinalProjectTrinhKizzieTheme

class HelpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalProjectTrinhKizzieTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HelpScreen(onBackPressed = { finish() })
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithBack(title: String, onBackPressed: () -> Unit) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
            }
        }
    )
}

@Composable
fun HelpScreen(onBackPressed: () -> Unit) {
    val helpItems = listOf(
        "How to add a task" to "Click on the text field at the bottom of the Todo List screen, enter your task, and press the 'Add' button.",
        "How to mark a task as complete" to "Tap the checkbox next to a task to mark it as complete.",
        "How to view preferences" to "Click the 'Preferences' button on the main screen to access app settings.",
        "How to get help" to "You're here! Click the 'Help' button on the main screen to view this information."
    )

    Scaffold(
        topBar = {
            TopBarWithBack(
                title = "Help & FAQ",
                onBackPressed = onBackPressed
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            items(helpItems) { (question, answer) ->
                HelpItem(question, answer)
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun HelpItem(question: String, answer: String) {
    Column {
        Text(text = question, style = MaterialTheme.typography.titleMedium)
        Text(text = answer, style = MaterialTheme.typography.bodyMedium)
    }
}


