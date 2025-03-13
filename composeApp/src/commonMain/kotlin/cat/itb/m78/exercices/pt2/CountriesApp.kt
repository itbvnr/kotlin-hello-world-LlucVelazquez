package cat.itb.m78.exercices.pt2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Countries(
    val capital: String, val name: String, val flag: String
)
class CountriesViewModel() : ViewModel(){
    val country = mutableStateOf<Countries?>(null)
    init {
        viewModelScope.launch(Dispatchers.Default) {
            country.value = CountriesApi.list().random()
        }
    }
    fun printCountries(){ viewModelScope.launch(Dispatchers.Default) {country.value = CountriesApi.list().random() } }
}

object CountriesApi {
    val url = "https://api.sampleapis.com/countries/countries"
    val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json{
                ignoreUnknownKeys = true
            })
        }
    }
    suspend fun list() = client.get(url).body<List<Countries>>()
}

@Composable
fun CountriesScreen() {
    val viewModel : viewModel{CountriesViewModel()}
    val country = viewModel.country.value

}