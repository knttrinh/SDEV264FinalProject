package com.example.finalprojecttrinhkizzie

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class TaskViewModel : ViewModel() {
    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> = _tasks.asStateFlow()


    fun addTask(title: String) {
        _tasks.update { currentTasks ->
            currentTasks + Task(id = currentTasks.size, title = title)
        }
    }

    fun updateTaskCompletion(task: Task, isCompleted: Boolean) {
        _tasks.update { currentTasks ->
            currentTasks.map {
                if (it.id == task.id) it.copy(isCompleted = isCompleted) else it
            }
        }
    }
    fun deleteTask(task: Task) {
        _tasks.value = _tasks.value.filter { it.id != task.id }
    }
}

data class Task(val id: Int, val title: String, var isCompleted: Boolean = false)