package cat.itb.m78.exercices

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable

object Destination {
    @Serializable
    data object Screen1
    @Serializable
    data class Screen2(var total: Float)
}

@Composable
fun LibNavScreenSample() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destination.Screen1) {
        composable<Destination.Screen1> {
            Screen1 { navController.navigate(Destination.Screen2(it)) }
        }
        composable<Destination.Screen2> { backStack ->
            var total = backStack.toRoute<Destination.Screen2>().total
            Screen2(total)
        }
    }
}