package cat.itb.m78.exercices

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import m78exercices.composeapp.generated.resources.Res
import m78exercices.composeapp.generated.resources.generated
import org.jetbrains.compose.resources.painterResource

data class Contact(val fullName: String, val email: String, val phone: String)

@Composable
fun ContactApp() {
    val contact = Contact("Marta Casserres", "marta@example.com", "934578484")
    Column(modifier = Modifier.fillMaxSize().background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Image(
            painter = painterResource(Res.drawable.generated),
            modifier = Modifier.size(100.dp).clip(CircleShape) ,
            contentDescription = null
        )
        Text(contact.fullName, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Column(modifier = Modifier.clip(RoundedCornerShape(10.dp)).background(Color.LightGray).padding(10.dp)) {
            Text(contact.email)
            Text(contact.phone)
        }
    }
}