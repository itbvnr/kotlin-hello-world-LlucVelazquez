package cat.itb.m78.exercices

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp

@Composable
fun HelloWorldApp() {
    Row (modifier = Modifier.background(Color.Yellow).fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically) {
        Text ("Hello")
        Spacer(Modifier.height(150.dp))
        Text("World")
        Spacer(Modifier.width(150.dp))
        Text("World")
        Spacer(Modifier.width(150.dp))
        Text("World")
        Spacer(Modifier.width(150.dp))
        Text("World")
        Spacer(Modifier.width(150.dp))
        Text("World")
        Spacer(Modifier.width(150.dp))

    }
    //Text("Hello World", color = Color.Red, fontStyle = FontStyle.Italic)
}