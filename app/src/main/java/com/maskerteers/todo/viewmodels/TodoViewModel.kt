package com.maskerteers.todo.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maskerteers.todo.data.Task
import com.maskerteers.todo.data.TaskRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * PROJECT NAME: TODO
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/20/24
 * TIME        : 10:55 AM
 */

class TodoViewModel(context: Context) : ViewModel() {

    /**
     * Manually initializing Repo and passing context not recommended
     * This was only done for the purposes of showing a simple Room implementation flow
     * ToDo: Use Dependency Injection instead (Consider Hilt, Koin)
     */
    val taskRepositoryImpl = TaskRepositoryImpl(context)

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks get() = _tasks.asStateFlow()

    init {
        readList()
    }

    fun saveList(task: Task){
        viewModelScope.launch {
            taskRepositoryImpl.saveTask(task)
        }
    }

    fun readList() {
        viewModelScope.launch {
            taskRepositoryImpl.getTasks().collect(){
                _tasks.value = it
            }
        }
    }
}