package cat.itb.m78.exercices


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import cat.itb.m78.exercices.theme.AppTheme
import cat.itb.m78.exercices.theme.Resource
import org.jetbrains.compose.reload.DevelopmentEntryPoint

@Composable
internal fun App() = AppTheme {
    //Box(Modifier.fillMaxSize()){
    //    Text("Your app goes here!", Modifier.align(Alignment.Center), color = Color.Blue)
    //}
    //HelloWorldApp()
    //Welcome()
    Resource()
}
