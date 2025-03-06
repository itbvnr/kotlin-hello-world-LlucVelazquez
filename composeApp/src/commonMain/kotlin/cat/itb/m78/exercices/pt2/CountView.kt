package cat.itb.m78.exercices.pt2

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.russhwolf.settings.Settings
import com.russhwolf.settings.set
import androidx.compose.material3.Text


@Composable
fun CountView() {
    val settings: Settings = Settings()
    var count: Int? = settings.getIntOrNull("key")
    //var count: Int? = settings["key"]
    if (count == null) {
        count = 0
    } else {
        //settings.putInt("key", count + 1)
        settings["key"] = count + 1
    }
    Column {
        Text("You have opened this app $count times")
    }
}