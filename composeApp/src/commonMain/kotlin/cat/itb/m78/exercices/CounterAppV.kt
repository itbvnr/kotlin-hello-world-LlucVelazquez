package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

class CounterAppView : ViewModel(){
    val local = mutableStateOf(0)
    val visit = mutableStateOf(0)
    fun updateLocal(){
        local.value += 1
    }
    fun updateVisit(){
        visit.value += 1
    }
}
@Composable
fun CounterApp2(navScreen2: () -> Unit){
    val viewModel = viewModel { CounterAppView() }
    val local = viewModel.local.value
    val visit = viewModel.visit.value
    CounterView(local, visit, viewModel::updateLocal, viewModel::updateVisit, navScreen2)
}
@Composable
fun CounterView(local: Int, visit: Int, updateLocal: () -> Unit, updateVisit: () -> Unit, navScreen2: () -> Unit) {
    Row{
        Column {
            Text(local.toString())
            Button(onClick = updateLocal) {
                Text("Score")
            }
        }
        Column {
            Text(visit.toString())
            Button(onClick = updateVisit) {
                Text("Score")
            }
        }
        Column {
            Button(onClick = navScreen2) {
                Text("hey")
            }
        }
    }
}
@Composable
fun Screen2(navScreen1: () -> Unit){
    val viewModel = viewModel { CounterAppView() }
    Column {
        Text(viewModel.local.value.toString())
        Text(viewModel.visit.value.toString())
        Button(onClick = navScreen1) { Text("Back") }
    }
}

object Destination {
    @Serializable
    data object Screen1
    @Serializable
    data object Screen2
}
@Composable
fun CounterVavScreen(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.Screen1) {
        composable<Destination.Screen1> { CounterApp2 {navController.navigate(Destination.Screen2) } }
        composable<Destination.Screen2> { Screen2 { navController.navigate(Destination.Screen1) } }
    }
}

/*
@Composable
fun CounterAppV(){
    val viewModel = viewModel {CounterAppView()}
    val local = viewModel.local.value
    val visit = viewModel.visit.value
    MaterialTheme{
        Row{
            Column {
                Text(local.toString())
                Button(onClick = { viewModel::updateLocal }) {
                    Text("Score")
                }
            }
            Column {
                Text(visit.toString())
                Button(onClick = { viewModel::updateVisit }) {
                    Text("Score")
                }
            }
        }

    }
}*/