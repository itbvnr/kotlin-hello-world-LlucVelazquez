package cat.itb.m78.exercices.ex3
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class goodJokes(val id: Int, val type: String, val setup: String, val punchline: String)


@Serializable
data class Rectangle(val height: Double, val width: Double)

fun main(){
    val serializer = Json {
        ignoreUnknownKeys = true
    }
    val rectangle = serializer.decodeFromString<Rectangle>("""{"width":10.0, "height":10.0,"color":"RED"}""")

    val json = Json.encodeToString(rectangle)

    val rectangleList = listOf(rectangle)
    val json2 = Json.encodeToString(rectangleList)

    println("Rectangle $rectangle")
    println("Json $json")
    println("Json2 $json2")
}