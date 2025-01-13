package cat.itb.m78.exercices
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Welcome() {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Welcome!", fontSize = 25.sp)
        Text("Start learning now")
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {  }) {Text("Login")}
        Button(onClick = {  }) { Text("Register") }
    }
}