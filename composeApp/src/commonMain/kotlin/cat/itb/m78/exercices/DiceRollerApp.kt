package cat.itb.m78.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.layout.ContentScale
import org.jetbrains.compose.resources.painterResource
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import m78exercices.composeapp.generated.resources.*
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.dice_1
import m78exercices.composeapp.generated.resources.tapestry
import m78exercices.composeapp.generated.resources.title
import kotlin.random.Random

@Composable
fun DiceRollerApp() {
    val Dices = listOf(Res.drawable.empty_dice,Res.drawable.dice_1, Res.drawable.dice_2, Res.drawable.dice_3, Res.drawable.dice_4, Res.drawable.dice_5, Res.drawable.dice_6,)
    var leftDice = remember { mutableStateOf(0) }
    var rightDice = remember { mutableStateOf(0) }
    //var dice1 = leftDice == 1
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) {
        Image(
            painter = painterResource(Res.drawable.tapestry),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(Res.drawable.title),
                contentDescription = null,

                )
            Button(onClick = {
                leftDice.value = Random.nextInt(1, 7)
                rightDice.value = Random.nextInt(1, 7)
                if (leftDice.value == 6 && rightDice.value == 6) {
                    scope.launch {
                        snackbarHostState.showSnackbar("JACKPOT!",
                            withDismissAction = true)
                    }
                }

            }) {
                Text("Roll the dice")
            }
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically) {
                Image(
                    painter = painterResource(Dices[leftDice.value],),
                    contentDescription = null
                )
                Image(
                    painter = painterResource(Dices[rightDice.value],),
                    contentDescription = null
                )
            }
        }
    }
}