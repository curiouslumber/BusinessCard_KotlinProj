package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme
import org.w3c.dom.Text

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardPreview()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(name: String, subtitle: String, phoneNumber: String, tag: String, email: String){

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFD2E8D4))) {
        CenterCard(name, subtitle, phoneNumber, tag, email)
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(name = stringResource(R.string.name), subtitle = stringResource(R.string.title), phoneNumber = stringResource(
            R.string.phone_num
        ), email = stringResource(R.string.email_id) , tag = stringResource(R.string.tag)
        )
    }
}

@Composable
fun CenterCard(name: String, subtitle: String, phoneNumber: String, tag: String, email: String){
    val image = painterResource(id = R.drawable.android_logo)
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
        Spacer(modifier = Modifier.weight(1f))
        Image(painter = image, contentDescription = "Android Logo", modifier = Modifier
            .background(Color(0xff073042))
            .size(120.dp))
        Text(text = name, fontSize = 36.sp, modifier = Modifier.padding( bottom = 4.dp, top = 2.dp), fontWeight = FontWeight.Light, color = Color(0xff1F2F22))
        Text(text = subtitle, fontWeight = FontWeight.Bold, color = Color(0xff308559))
        Spacer(modifier = Modifier.weight(1f))
        SocialInfo(phoneNumber = phoneNumber, tag = tag, email = email)
    }
}

@Composable
fun SocialInfo(phoneNumber: String, tag: String, email: String){
    val phoneIconImage = painterResource(id = R.drawable.baseline_phone_24)
    val shareIconImage = painterResource(id = R.drawable.baseline_share_24)
    val emailIconImage = painterResource(id = R.drawable.baseline_email_24)
    Column (horizontalAlignment = Alignment.Start){
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.padding(bottom = 16.dp)) {
            Image(painter = phoneIconImage, contentDescription = "Phone Icon")
            Text(text = phoneNumber, Modifier.padding(start = 16.dp), textAlign = TextAlign.Start)
        }
        Row(modifier = Modifier.padding(bottom = 16.dp)) {
            Image(painter = shareIconImage, contentDescription = "Share Icon")
            Text(text = tag,  Modifier.padding(start = 16.dp),  textAlign = TextAlign.Start)
        }
        Row(modifier = Modifier.padding(bottom = 32.dp)) {
            Image(painter = emailIconImage, contentDescription = "Share Icon")
            Text(text = email, modifier = Modifier.padding(start = 16.dp),  textAlign = TextAlign.Start)
        }
    }
}
