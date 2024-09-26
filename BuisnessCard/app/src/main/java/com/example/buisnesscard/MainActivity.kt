package com.example.buisnesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buisnesscard.ui.theme.BuisnessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BuisnessCardTheme {
                BuisnessCard()
            }
        }
    }
}
/*
@Composable
fun BuisnessCard(){
    Column (
        modifier = Modifier
    ){
        val img = painterResource(R.drawable.my_face)
        Image(painter = img, contentDescription = null, modifier = Modifier.width(150.dp))
        Text(
            text = "Tagir",
            fontSize = 26.sp
        )
        Text(
            text = "Golang programmer",
            textAlign = TextAlign.Justify
        )
    }
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(top = 500.dp, bottom = 70.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row (
            modifier = Modifier.fillMaxSize().padding(start = 40.dp)
        ) {
            Icon(Icons.Rounded.Phone, contentDescription = null)
            Text("8(927)677-18-94")
        }
        Row (
            modifier = Modifier.fillMaxSize().padding(start = 40.dp)
        ) {
            Icon(Icons.Rounded.Send, contentDescription = null)
            Text("@Qequqek")
        }
        Row (
            modifier = Modifier.fillMaxSize().padding(start = 40.dp)
        ) {
            Icon(Icons.Rounded.Email, contentDescription = null)
            Text("songatov@gmail.com")
        }
    }
}
*/


@Composable
fun BuisnessCard(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF385)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(Modifier.weight(1f))
        BuisnessCardMain(
            fullName = "Tagir",
            title = "Golang programmer",
            modifier = Modifier.weight(1.5f)
        )
        Spacer(Modifier.weight(1f))
        BuisnessCardSocial(
            phone = "8(927)677-18-94",
            telegram = "@Qequqek",
            mail = "songatov@gmail.com",
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun SocialLine(icon: ImageVector, social: String, modifier: Modifier = Modifier){
    Row (modifier = modifier){
        Icon(
            icon,
            contentDescription = null
        )
        Spacer(Modifier.width(30.dp))
        Text(
            text = social
        )
    }
}

@Composable
fun BuisnessCardSocial(phone: String, telegram: String, mail: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize().padding(bottom = 70.dp, start = 70.dp)
    ) {
        SocialLine(
            icon = Icons.Rounded.Phone,
            social = phone,
            modifier = modifier
        )
        SocialLine(
            icon = Icons.Rounded.Send,
            social = telegram,
            modifier = modifier
        )
        SocialLine(
            icon = Icons.Rounded.Email,
            social = mail,
            modifier = modifier
        )
    }
}

@Composable
fun BuisnessCardMain(fullName: String, title: String, modifier: Modifier = Modifier) {
    val myFace = painterResource(R.drawable.my_face)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = myFace,
            contentDescription = "my face",
            modifier = modifier.width(150.dp)
        )
        Text(
            text = fullName,
            fontSize = 26.sp,
            modifier = modifier
        )
        Text(
            text = title,
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BuisnessCardTheme {
        BuisnessCard()
    }
}