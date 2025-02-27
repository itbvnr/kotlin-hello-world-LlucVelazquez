package cat.itb.m78.exercices.pt2

import androidx.lifecycle.ViewModel
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.serialization.SerialName

@Serializable
data class CurrentBcnTrees(
    @SerialName("nom_cientific") val scientificName : String,
    @SerialName("nom_catala") val name: String?,
    @SerialName("adreca") val adress: String
)

suspend fun main(){
    val client = HttpClient(){
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
            })
        }
    }
    val trees : List<CurrentBcnTrees> = client.get("https://fp.mateuyabar.com/DAM-M03/UF3/exercicis/files/OD_Arbrat_Zona_BCN.json").body()
    println("There are ${trees.size} in Barcelona")
}