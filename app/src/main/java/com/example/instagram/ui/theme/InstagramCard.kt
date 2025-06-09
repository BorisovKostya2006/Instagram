package com.example.instagram.ui.theme


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagram.R
import org.w3c.dom.Text

@Preview()
@Composable
fun InstagramCard() {
    val clickState = rememberSaveable { mutableStateOf(true) }
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        shape = RoundedCornerShape(
            topEnd = 4.dp,
            topStart = 4.dp
        ),
        border = BorderStroke(width = 1.dp, MaterialTheme.colorScheme.onBackground)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth()
                    ,
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    modifier = Modifier.size(50.dp)
                        .clip(CircleShape)
                        .background(Color.White),
                    painter = painterResource(id = R.drawable.instagram),
                    contentDescription = "",
                )
                UserStatics(value = "6,950", title = "posts")
                UserStatics(value = "436M", title = "followers")
                UserStatics(value = "76", title = "following")
            }
            Text(text = "Instagram",
                fontSize = 32.sp,
                fontFamily = FontFamily.Cursive)
            Text(text = "#YoursToMake",
                fontSize = 14.sp)
            Text(text = "www.facebook.com/emotional_health",
                fontSize = 14.sp)
            Button (onClick = {
                    clickState.value = !clickState.value
            },  shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (!clickState.value) {
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)
                    }
                    else{
                        MaterialTheme.colorScheme.primary
                    }
                )
                )
            {
                val unfollow = "Unfollow"
                val follow = "Follow"
                if (clickState.value){
                    Text(text = follow)
                }else{
                    Text(text = unfollow)
                }

            }
        }

    }
}
@Composable
private fun UserStatics(
    value: String,
    title: String
){
    Column {

        Text(
            text = value,
            fontSize = 24.sp,
            fontFamily = FontFamily.Cursive
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold
        )
    }

}