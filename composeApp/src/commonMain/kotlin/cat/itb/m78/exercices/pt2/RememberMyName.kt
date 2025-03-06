package cat.itb.m78.exercices.pt2

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set

@Composable
fun RememberMyName() {
    var text by remember { mutableStateOf("") }
    val settings: Settings = Settings()
    var name : String? = settings.getStringOrNull("key")
    if (name == null || name == "") {
        name = "cosa"
    } else {
        name = text
    }
    Column {
        Text("Hola $name")
        TextField(text, onValueChange = {text = it
                                        settings["key"] = text}, label = {})
    }
}