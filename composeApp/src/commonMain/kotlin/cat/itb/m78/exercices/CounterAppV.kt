package cat.itb.m78.exercices

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class CounterAppView : ViewModel(){
    var local: Int = 0
    var visit: Int = 0
    fun updateLocal(){
        local++
    }
    fun updateVisit(){
        visit++
    }
}




@Composable
fun CounterAppV(){
    val viewModel = viewModel {CounterAppView()}
    MaterialTheme{
        Row{
            Column {
                Text(viewModel.local.toString())
                Button(onClick = { viewModel::updateLocal }) {
                    Text("Score")
                }
            }
            Column {
                Text(viewModel.visit.toString())
                Button(onClick = { viewModel::updateVisit }) {
                    Text("Score")
                }
            }
        }

    }
}