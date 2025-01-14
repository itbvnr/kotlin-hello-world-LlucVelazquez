package cat.itb.m78.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.generatedFace
import org.jetbrains.compose.resources.painterResource

@Composable
fun Resource() {
    Column() {
        Text("This is a resources string")
        Row {
            Spacer(Modifier.width(40.dp))
            Image(
                painter = painterResource(Res.drawable.generatedFace),
                modifier = Modifier.size(100.dp),
                contentDescription = null
            )
        }
    }
}