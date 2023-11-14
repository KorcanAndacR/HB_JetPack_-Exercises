package com.roof.hbjetpackexercises

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roof.hbjetpackexercises.ui.theme.HbjetpackexercisesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HbjetpackexercisesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var textValue by remember {
                       mutableStateOf("")
                    }
                    var isLength by remember {
                        mutableStateOf(false)
                    }

                    Column(
                        modifier = Modifier
                    ) {
                        Text(text = "-  BOŞ - ")
                        /*HbTextField(textValue = textValue) {
                            textValue = it
                        }*/
                        OutlinedTextField(
                            value = textValue,
                            onValueChange = {
                                if (it.length<6) {
                                    isLength = false
                                    textValue = it
                                } else {
                                    isLength = true
                                }
                            },
                            modifier = Modifier,
                            )
                        Spacer(modifier = Modifier.height(12.dp))
                        if (isLength) {
                            Text(text = "En fazla 5 karakter girebilirsiniz!", color = Color.Red)
                        }
                        Button(
                            onClick = {

                            }) {
                            Text(text = "GİRİŞ")
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HbTextField(
    textValue: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = {
            onValueChange(it)
        },
        modifier = Modifier,
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HbjetpackexercisesTheme {
        Greeting("Android")
    }
}