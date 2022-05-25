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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.BorderStroke
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import com.example.helloapp.ui.theme.HelloAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val message = remember{mutableStateOf("")}
            val name = remember{mutableStateOf("")}
            val surname = remember{mutableStateOf("")}
            val phone = remember{mutableStateOf("")}
            fun сlearTextField ()
            {
                name.value = ""
                surname.value = ""
                phone.value = ""
            }
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

                Column(verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
                    .weight(8f)
                    .verticalScroll(rememberScrollState())
                )
                {
                    TextField(value = name.value,
                        textStyle = TextStyle(fontSize=25.sp),
                        onValueChange = {newText -> name.value = newText},
                        placeholder = {Text("Имя", fontSize = 20.sp)},
                        singleLine = true
                    )
                    TextField(value = surname.value,
                        textStyle = TextStyle(fontSize=25.sp),
                        onValueChange = {newText -> surname.value = newText},
                        placeholder = {Text("Фамилия", fontSize = 20.sp)},
                        singleLine = true
                    )
                    TextField(value = phone.value,
                        textStyle = TextStyle(fontSize=25.sp),
                        onValueChange = {newText -> phone.value = newText},
                        placeholder = {Text("Телефон", fontSize = 20.sp)},
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                }

                Row(modifier = Modifier
                    .background(Color(0xB3136df2))
                    .weight(1f),
                )
                {
                    TextButton(onClick = { сlearTextField() }, modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                        colors = ButtonDefaults.textButtonColors(contentColor = Color.Black)
                    )
                    {
                        Text("Очистить", fontSize = 25.sp)
                    }
                    TextButton(onClick = {}, modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight(),
                        enabled = false
                    )
                    {
                        Text("Добавить", fontSize = 25.sp)
                    }
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