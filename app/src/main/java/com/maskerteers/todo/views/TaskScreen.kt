package com.maskerteers.todo.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maskerteers.todo.data.TaskList

/**
 * PROJECT NAME: TODO
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/18/24
 * TIME        : 9:53 PM
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskScreen() {

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "TODO App") })
    }, content = {
        TaskScreenContent(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(), tasks = emptyList()
        )
    }, floatingActionButton = {
        ListViewFloatingActionButton(title = "What would you like to do today?",
            inputHint = "Add you task",
            onFabClick = {

            })
    })
}

@Composable
fun TaskScreenContent(modifier: Modifier, tasks: List<TaskList>) {
    if (tasks.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.List,
                contentDescription = "List Icon",
                modifier = Modifier.size(100.dp)
            )
            Text(text = "Nothing to do now")
        }
    } else {
        LazyColumn(modifier = modifier,
            content = {
                items(tasks) {
                    ListViewItem(value = it.name)
                }
            })
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

    TaskScreen()

}