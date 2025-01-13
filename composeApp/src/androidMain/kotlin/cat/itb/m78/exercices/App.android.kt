package cat.itb.m78.exercices/home/lluc.velazquez.7e8/Documents/kotlin/kotlin-hello-world-LlucVelazquez-main/composeApp/src/commonMain/kotlin/androidx/compose/desktop/ui/tooling/preview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class AppActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { App() }
    }
}

@Preview
@Composable
fun AppPreview() { App() }
