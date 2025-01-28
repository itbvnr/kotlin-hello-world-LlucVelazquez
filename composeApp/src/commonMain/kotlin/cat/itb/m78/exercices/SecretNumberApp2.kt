package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import kotlin.random.Random

@Composable
fun SecretNumberApp2() {
    var text by remember { mutableStateOf("") }
    var show by remember { mutableStateOf(false) }
    val random1 = Random.nextInt(1, 100)
    var textCorrect = remember { mutableStateOf("") }
    var num by remember { mutableStateOf(0) }
    Column(){
        TextField(text,
            label = { Text("") },
            onValueChange = {
                text = it
                show = false
            })
        Button(onClick = {
            num ++
            show = true
        }){
            Text("Validar")
        }
        Text("Intents: $num")
        Text(textCorrect.value)

        if (show) {
            if (text.toInt() == random1) {
                textCorrect.value = "Has Encertat!"
            }else if(text.toInt() > random1){
                textCorrect.value = "El número que busques és més petit!"
            }else if(text.toInt() < random1){
                textCorrect.value = "El número que busques és més gran!"
            }
        }
    }
}