package com.maskerteers.todo.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Insert()
    suspend fun saveTask(task: Task): Long

    @Query("SELECT * from Task")
    fun getTasks(): Flow<List<Task>>

}