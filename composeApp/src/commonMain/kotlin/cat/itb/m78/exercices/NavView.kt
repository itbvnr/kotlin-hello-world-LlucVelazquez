/*package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.MutableStateFlow

private sealed interface Screen {
    data object Screen1 : Screen
    data object Screen3 : Screen
    data class Screen4(val message: String) : Screen
}
private class ManualNavAppViewModel : ViewModel(){
    val currentScreen = mutableStateOf<Screen>(Screen.Screen1)

    fun navigateTo(screen: Screen) {
        currentScreen.value = screen
    }
}



@Composable
fun ManualNav2(){
    val viewModel = viewModel { ManualNavAppViewModel() }
    val currentScreen = viewModel.currentScreen.value
    when(currentScreen){
        Screen.Screen1 -> Screen1(
            navigateToScreen2 = { viewModel.navigateTo(Screen.Screen3) },
        )
        is Screen.Screen3 -> Screen3(
            navigateToScreen4 = { viewModel.navigateTo(Screen.Screen4(it)) },
        )
        is Screen.Screen4 -> Screen4(currentScreen.message)
    }
}
@Composable
fun Screen1(navigateToScreen2: () -> Unit) {
    Column {
        Text("GO to Screen2")
        Button(onClick = navigateToScreen2) {
            Text("Go to Screen2")
        }
    }
}
@Composable
fun Screen3(navigateToScreen4: (String) -> Unit) {
    var text by remember { mutableStateOf("") }
    Column {
        TextField(text, onValueChange = {text = it})
        Button(onClick = {navigateToScreen4(text)}) {
            Text("Go to Screen3")
        }
    }
}
@Composable
fun Screen4(message: String) {
    Text(message)
}*/