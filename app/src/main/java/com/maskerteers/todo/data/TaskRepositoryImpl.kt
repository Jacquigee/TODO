package com.maskerteers.todo.data

import android.content.Context
import android.util.Log
import kotlinx.coroutines.flow.Flow

class TaskRepositoryImpl(context: Context) {

    /**
     * Manually initializing DB and passing context not recommended
     * This was only done for the purposes of showing a simple Room implementation flow
     * ToDo: Use Dependency Injection instead (Consider Hilt, Koin)
     */
    private val appDatabase = AppDatabase.getDatabaseInstance(context)
    suspend fun saveTask(task: Task) {
        try {
            appDatabase.taskDao().saveTask(task)
        } catch (e: Exception) {
            Log.e("KUAPP:", " Error ${e.message.toString()}")
        }
    }

    fun getTasks(): Flow<List<Task>> {
        val tasks = appDatabase.taskDao().getTasks()
        return tasks
    }
}