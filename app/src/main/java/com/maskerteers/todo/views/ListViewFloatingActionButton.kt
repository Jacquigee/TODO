package com.maskerteers.todo.views

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * PROJECT NAME: TODO
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/18/24
 * TIME        : 8:59 PM
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListViewFloatingActionButton(
    title: String, inputHint: String, onFabClick: (String) -> Unit
) {
    var showDialog by remember {
        mutableStateOf(false)
    }

    var taskName by remember {
        mutableStateOf("")
    }

    FloatingActionButton(onClick = { showDialog = true}, content = {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add icon")
    })

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text(text = title) },
            text = {
                OutlinedTextField(
                    value = taskName,
                    onValueChange = { taskName = it },
                    label = { Text(text = inputHint) },
                    singleLine = true
                )
            },
            confirmButton = {
                Button(
                    onClick = {
                        showDialog = false
                        onFabClick(taskName)
                        taskName = ""
                    },
                    content = {
                        Text(text = "Label")
                    }
                )
            },
        )

    }
}



