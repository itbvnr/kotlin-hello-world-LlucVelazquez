package cat.itb.m78.exercices

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Screen1(navigateToScreen2: (Float)-> Unit){
    var cant by remember{ mutableStateOf(0) }
    val radioOptions = listOf("Talla petita: 10,0€","Talla mitjana: 15,0€", "Talla gran: 20,0€")
    var talla by remember{ mutableStateOf(0)}
    var tallatext by remember { mutableStateOf("") }
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(radioOptions[0]) }
    var text2 by remember{ mutableStateOf("") }
    var preu by remember { mutableStateOf(0.0f) }
    var total by remember { mutableStateOf(0.0f) }
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Text("Venda de samarretes", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(text2, onValueChange = {text2 = it})
        radioOptions.forEach { text ->
            Row(Modifier.selectable(
                selected = (text == selectedOption),
                onClick = { onOptionSelected(text) },
                role = Role.RadioButton
            )
                .padding(horizontal = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (text == selectedOption),
                    onClick = null
                )
                Text(
                    text = text
                )
            }
        }
        if(selectedOption == radioOptions[0])
        {
            talla = 1
            tallatext = "Petita"
            preu = 10.0.toFloat()
        }else if(selectedOption == radioOptions[1]){
            talla = 2
            tallatext = "Mitjana"
            preu = 15.0.toFloat()
        }else if(selectedOption == radioOptions[2]){
            talla = 3
            tallatext = "Gran"
            preu = 20.0.toFloat()
        }
        if(text2 != ""){
            cant = text2.toInt()
        }
        Text("Numero de samarretes: $cant")
        Text("Talla seleccionada: $tallatext")
        total = (cant * preu)
        Text("Preu de les samarretes: $total€")
        Button(onClick = {navigateToScreen2(total)}){
            Text("Comanda")
        }
    }

}

@Composable
fun Screen2(total: Float){
    var iva = total * 1.21
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        Text("Venda de samarretes", fontSize = 30.sp)
        Spacer(modifier = Modifier.height(20.dp))
        Text("Preu de la comanda: $total€")
        Text("Preu amb IVA: $iva€")
    }
}