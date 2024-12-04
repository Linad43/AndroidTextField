package com.example.androidtextfield

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListProduct()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@SuppressLint("Range")
@Preview(showBackground = true)
@Composable
fun ListProduct() {
    val textInput = remember { mutableStateOf("") }
    val arr = remember { mutableStateListOf("one", "two", "three") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .background(Color.LightGray)
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Динамический список",
                color = Color.White,
                textAlign = Center,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
                    .padding(10.dp)
            )
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .height(100.dp)
            ) {
                items(arr) {
                    Text(
                        text = it,
                        textAlign = Center,
                        modifier = Modifier
                            .padding(2.dp)
                            .fillMaxWidth()
                            .background(Color.White, RoundedCornerShape(10.dp))
                            .clickable(onClick ={
                                arr.remove(it)
                            })
                    )
                }
            }
        }
        TextField(
            value = textInput.value,
            textStyle = TextStyle(fontSize = 24.sp),
            onValueChange = {
                textInput.value = it
            },
            modifier = Modifier
                .padding(10.dp)
                .border(3.dp, Color.Black)
        )
        Text(
            text = "Добавить",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable(onClick = {
                    arr.add(textInput.value)
                    textInput.value = ""
                })
        )
    }
}