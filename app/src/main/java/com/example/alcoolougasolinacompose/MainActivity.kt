package com.example.alcoolougasolinacompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.alcoolougasolinacompose.ui.theme.AlcoolOuGasolinaComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlcoolOuGasolinaComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }

}

@Composable
fun App() {

    var valorGasolina by remember {
        mutableStateOf("")
    }
    var valorAlcool by remember {
        mutableStateOf("")
    }





    Column(
        Modifier
            .background(color = Color(0xFF00B2CE))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Álcool ou Gasolina",
                style = TextStyle(
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,

                    )
            )



            if(valorAlcool.isNotBlank() && valorGasolina.isNotBlank()){
                val ehGasolina = valorAlcool.toDouble() / valorGasolina.toDouble() > 0.7
                val alcoolOuGasolina = if (ehGasolina) {
                    "Gasolina"
                } else {
                    "Álcool"
                }
                val cor = if (ehGasolina) {
                    Color.Red
                } else {
                    Color.Green
                }

                Text(
                    text = alcoolOuGasolina,

                    style = TextStyle(
                        color = cor,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold,

                        )
                )
            }

            TextField(
                value = valorGasolina,
                onValueChange = {
                    valorGasolina = it
                },
                label = { Text(text = "Gasolina") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)


            )

            TextField(value = valorAlcool,
                onValueChange = {
                    valorAlcool = it
                },
                label = { Text(text = "Álcool") },
                 keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
        }
    }

}

@Preview
@Composable
fun AppPreview() {
    AlcoolOuGasolinaComposeTheme {
        App()
    }
}