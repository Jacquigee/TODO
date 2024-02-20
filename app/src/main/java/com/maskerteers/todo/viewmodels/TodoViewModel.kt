package com.maskerteers.todo.viewmodels

import androidx.lifecycle.ViewModel
import com.maskerteers.todo.data.TaskList

/**
 * PROJECT NAME: TODO
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/20/24
 * TIME        : 10:55 AM
 */

class TodoViewModel : ViewModel() {

    fun saveList(list: TaskList){

    }

    fun readList(): ArrayList<TaskList>{
        val taskList = ArrayList<TaskList>()
        return taskList
    }
}