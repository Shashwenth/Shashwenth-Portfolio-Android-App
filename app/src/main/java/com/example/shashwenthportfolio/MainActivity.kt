package com.example.shashwenthportfolio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shashwenthportfolio.ui.theme.ShashwenthPortfolioTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.TextUnit
import kotlinx.coroutines.delay
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShashwenthPortfolioTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                            .background(Color(0xFF2C3E50)),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Greeting(
                            name = "Shashwenth",
                            role = "Software Engineer"
                        )
                    }
                }
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, role: String, modifier: Modifier = Modifier) {
//    val cursiveFont = FontFamily(Font(R.font.richland))
//    Column(
//        modifier = modifier.fillMaxWidth(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text(
//            text = "Hi, I am $name",
//            color = Color.White,
//            fontFamily = cursiveFont,
//            fontSize = 35.sp
//        )
//        Text(
//            text = "I am a $role",
//            color = Color.White,
//            fontFamily = cursiveFont,
//            fontSize = 30.sp,
//            modifier = modifier.padding(bottom = 50.dp).padding(top = 10.dp)
//        )
//        Text(
//            text = "Welcome to my",
//            color = Color.White,
//            fontFamily = cursiveFont,
//            modifier = modifier.padding(top = 50.dp),
//            fontSize = 30.sp
//        )
//        Text(
//            text = "Portfolio App",
//            color = Color.White,
//            fontFamily = cursiveFont,
//            fontSize = 30.sp
//        )
//    }
//}


@Preview(showBackground = true)
@Composable
fun PreviewGreeting() {
    ShashwenthPortfolioTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .background(Color(0xFF2C3E50)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting(
                    name = "Shashwenth",
                    role = "Software Engineer"
                )
            }
        }
    }
}

@Composable
fun TypewriterText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Unspecified,
    fontFamily: FontFamily? = null,
    fontSize: TextUnit = TextUnit.Unspecified,
    delay: Long = 100,
    initialDelay: Long
) {
    var displayedText by remember { mutableStateOf("") }
    var currentIndex by remember { mutableStateOf(0) }

    //LaunchedEffect(text) {
    LaunchedEffect(Unit){
        delay(initialDelay)
        while (currentIndex < text.length) {
            delay(delay)
            displayedText = text.substring(0, currentIndex + 1)
            currentIndex++
        }
    }
    //}

    Text(
        text = displayedText,
        modifier = modifier,
        color = color,
        fontFamily = fontFamily,
        fontSize = fontSize
    )
}

@Composable
fun Greeting(name: String, role: String, modifier: Modifier = Modifier) {
    val cursiveFont = FontFamily(Font(R.font.richland))

    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TypewriterText(
            text = "Hi, I am $name",
            color = Color.White,
            fontFamily = cursiveFont,
            fontSize = 35.sp,
            delay = 100,
            initialDelay=0
        )
        TypewriterText(
            text = "I am a $role",
            color = Color.White,
            fontFamily = cursiveFont,
            fontSize = 30.sp,
            modifier = modifier.padding(bottom = 50.dp).padding(top = 10.dp),
            delay = 100,
            initialDelay = 2200
        )
        TypewriterText(
            text = "Welcome to my",
            color = Color.White,
            fontFamily = cursiveFont,
            modifier = modifier.padding(top = 50.dp),
            fontSize = 30.sp,
            delay = 100,
            initialDelay = 4500
        )
        TypewriterText(
            text = "Portfolio App",
            color = Color.White,
            fontFamily = cursiveFont,
            fontSize = 30.sp,
            delay = 100,
            initialDelay = 5800
        )
    }
}