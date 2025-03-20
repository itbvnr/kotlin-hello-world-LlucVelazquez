package cat.itb.m78.exercices.pt2

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import androidx.compose.ui.unit.dp
import com.russhwolf.settings.Settings

@Serializable
data class Embassament(
    val estaci: String, val dia: String, val nivell_absolut: String, val percentatge_volum_embassat: String, val volum_embassat: String
)
class EstatEmbassamentViewModel() : ViewModel(){
    val embassaments = mutableStateOf<List<Embassament>?>(null)
    init {
        viewModelScope.launch(Dispatchers.Default) {
            embassaments.value = EmbassamentApi.list()
        }
    }
    fun printEmbassaments() { viewModelScope.launch(Dispatchers.Default) {embassaments.value = EmbassamentApi.list()} }
}

object EmbassamentApi {
    val url = "https://analisi.transparenciacatalunya.cat/resource/gn9e-3qhr.json"
    val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json{
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun list() = client.get(url).body<List<Embassament>>()
}
@Composable
fun EstatEmbassamentScreen() {
    val viewModel = viewModel{EstatEmbassamentViewModel()}
    val embassaments = viewModel.embassaments.value
    val settings : Settings = Settings()
    var preferit: String? = settings.getStringOrNull("key")
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        if (embassaments != null) {
            Text("$preferit")
            Spacer(Modifier.height(8.dp))
            LazyColumn(modifier = Modifier) {
                embassaments.forEach { embassament->
                    item {
                        Row {
                            Button(onClick = {
                                settings.putString("key", embassament.estaci)
                            }){
                                Column(horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center) {
                                    Text("Dia: ${embassament.dia}")
                                    Text("Estaci: ${embassament.estaci}")
                                    Text("Nivell absolut: ${embassament.nivell_absolut}")
                                    Text("Percentatge: ${embassament.percentatge_volum_embassat}")
                                    Text("Volum embassat: ${embassament.volum_embassat}")
                                }
                            }
                        }
                        Spacer(Modifier.height(8.dp))
                    }
                }
            }
        }
        else{
            Row() {
                CircularProgressIndicator()
            }
        }
    }
}