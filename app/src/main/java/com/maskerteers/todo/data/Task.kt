package com.maskerteers.todo.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * PROJECT NAME: TODO
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/18/24
 * TIME        : 9:46 PM
 */


/**
 * [Task] is a data class that represents the values needed on a single task.
 * [name] is a value of type string that will be used to store the name of the task.
 * [taskList] is a value of type list which takes in a list of tasks. The value will be used to hold the list of tasks on the list screen.
 */
@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "task_name")
    var name: String
)