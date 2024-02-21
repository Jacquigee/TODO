package com.maskerteers.todo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.maskerteers.todo.ui.theme.TODOTheme
import com.maskerteers.todo.viewmodels.TodoViewModel
import com.maskerteers.todo.views.TaskScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * Manually initializing VM and passing context not recommended,
         * This was only done for the purposes of showing a simple Room implementation flow
         * ToDo: Use Dependency Injection instead (Consider Hilt, Koin)
         */
        val viewModel = TodoViewModel(this)

        setContent {
            TODOTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TaskScreen(viewModel)
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TODOTheme { }
}