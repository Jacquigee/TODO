package com.maskerteers.todo.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * PROJECT NAME: TODO
 * USER        : jacqui
 * EMAIL       : gitaujaquiline@gmail.com
 * DATE        : Feb, 2/18/24
 * TIME        : 8:23 PM
 */

@Composable
fun ListViewItem(value: String) {

    Surface(modifier = Modifier
        .fillMaxWidth()
        .padding(10.dp),
        shape = RoundedCornerShape(10),
        color = Color.LightGray) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = value, modifier = Modifier.padding(4.dp))
        }
        Spacer(modifier = Modifier.padding(8.dp))

    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListViewItemPreview() {
    ListViewItem(value = "Finish my code assignment")
}