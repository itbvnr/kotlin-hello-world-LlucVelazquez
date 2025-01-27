package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*

@Composable
fun SecretNumberApp() {
    var text by remember { mutableStateOf("Hello, World!") }
    var show by remember { mutableStateOf(false) }
    Column(){
        TextField(text,
            label = { Text("") },
            onValueChange = {
                text = it
            })
        Button(onClick = {
            show = true
        }){
            Text("SayHello")
        }
        if (show) AlertDialog(
            onDismissRequest = { show = false },
            confirmButton = {},
            title = { Text("Hello $text") },
        )
    }
}
