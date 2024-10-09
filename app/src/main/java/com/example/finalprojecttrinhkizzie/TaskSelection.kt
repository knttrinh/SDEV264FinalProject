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
import com.example.finalprojecttrinhkizzie.ui.theme.FinalProjectTrinhKizzieTheme

class TaskTypeSelectionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalProjectTrinhKizzieTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskTypeSelectionScreen(
                        onTodoClick = {
                            startActivity(Intent(this, TodoListActivity::class.java))
                        },
                        onPreferencesClick = {
                            startActivity(Intent(this, PreferencesActivity::class.java))
                        },
                        onHelpClick = {
                            startActivity(Intent(this, HelpActivity::class.java))
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TaskTypeSelectionScreen(
    onTodoClick: () -> Unit,
    onPreferencesClick: () -> Unit,
    onHelpClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onTodoClick) {
            Text("Todo List")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onPreferencesClick) {
            Text("Preferences")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = onHelpClick) {
            Text("Help")
        }
    }
}