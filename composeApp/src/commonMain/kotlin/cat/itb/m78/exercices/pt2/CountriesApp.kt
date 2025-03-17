package cat.itb.m78.exercices.pt2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Serializable
data class Countries(
    val capital: String, val name: String, val media: Media
)
@Serializable
data class Media(
    val flag: String
)
class CountriesViewModel() : ViewModel(){
    val country = mutableStateOf<List<Countries>?>(null)
    init {
        viewModelScope.launch(Dispatchers.Default) {
            country.value = CountriesApi.list()
        }
    }
    fun printCountries(){ viewModelScope.launch(Dispatchers.Default) {country.value = CountriesApi.list() } }
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
    val viewModel = viewModel{CountriesViewModel()}
    val countries = viewModel.country.value
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        if (countries != null) {
            LazyColumn(modifier = Modifier){
                countries.forEach { country ->
                    item {
                        Row {
                            Text(country.capital)
                            Text(country.name)
                            AsyncImage(
                                model = country.media.flag,
                                contentDescription = null,
                                modifier = Modifier.size(25.dp)
                            )
                        }
                    }
                }
            }
        }
        else{
            Row(){
                CircularProgressIndicator()
            }
        }
    }


}