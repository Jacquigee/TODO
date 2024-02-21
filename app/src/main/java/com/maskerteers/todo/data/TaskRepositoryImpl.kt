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
            Log.e("KUAPP: ", "Repo saveTask() $task")
            appDatabase.taskDao().saveTask(task)
        } catch (e: Exception) {
            Log.e("KUAPP:", " Error ${e.message.toString()}")
        }
    }

    suspend fun getTasks(): Flow<List<Task>> {
        val tasks = appDatabase.taskDao().getTasks()
        Log.e("KUAPP: ", "Repo getTasks() $tasks")
        return tasks
    }
}