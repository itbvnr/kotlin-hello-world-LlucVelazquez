package cat.itb.m78.exercices.pt2

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Embassament(
    val cosa: String
)

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