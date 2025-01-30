package cat.itb.m78.exercices

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.runtime.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CounterApp() {
    var Score1 by remember { mutableStateOf(0) }
    var Score2 by remember { mutableStateOf(0) }
    Column {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Text("$Score1")
            Spacer(Modifier.width(100.dp))
            Text("$Score2")
        }
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = {
                Score1++
            }){
                Text("Score")
            }
            Button(onClick = {
                Score2++
            }){
                Text("Score")
            }
        }
    }

}