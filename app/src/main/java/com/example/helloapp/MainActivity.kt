package com.example.helloapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.example.helloapp.ui.theme.HelloAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val count1 = remember{mutableStateOf(0)}
            val count2 = remember{mutableStateOf(0)}
            Column {
                Box(contentAlignment = Alignment.BottomCenter,
                    modifier = Modifier
                    .background(Color(0xB3136df2))
                    .fillMaxWidth()
                    .weight(1f),
                )
                {
                    Text("Welcome to my first App!", fontSize = 30.sp)
                }
                Box(modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .weight(8f)
                    .verticalScroll(rememberScrollState())
                )
                {
                    Text("TEST\nTEST\nTEST\nTEST\nTEST\nTEST\nTEST\nTEST\nTEST\nTEST\n" +
                                "TEST\n" +
                                "TEST\n" +
                                "TEST\n" +
                                "TEST\n" +
                                "TEST\n" +
                                "TEST\n" +
                                "TEST\n" +
                                "TEST\n" +
                                "TEST", fontSize = 50.sp
                    )
                }
                Row(modifier = Modifier
                    .background(Color(0xB3136df2))
                    //.fillMaxWidth()
                    .weight(1f),
                    //horizontalArrangement = Arrangement.SpaceBetween,
                    //verticalAlignment = Alignment.CenterVertically
                )
                {
                    Text(
                        "Click1: ${count1.value}", fontSize = 30.sp, modifier = Modifier
                            .clickable(onClick = { count1.value += 1 })
                            .weight(1f)
                            .fillMaxHeight()
                    )
                    Text(
                        "Click2: ${count2.value}", fontSize = 30.sp, modifier = Modifier
                            .clickable(onClick = { count2.value += 1 })
                            .weight(1f)
                            .fillMaxHeight()
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello, $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HelloAppTheme {
        Greeting("Android")
    }
}