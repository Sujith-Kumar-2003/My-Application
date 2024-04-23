package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", this)
                }
            }
        }
    }
}

@Composable
fun PanicButton(onClick: () -> Unit, modifier: Modifier = Modifier, context: Context) {
    Button(
        onClick = {
            onClick()
            // Show a toast message when the button is clicked
            Toast.makeText(context, "Panic button is pressed", Toast.LENGTH_SHORT).show()
        },
        modifier = modifier.padding(16.dp)
    ) {
        Text("Panic")
    }
}

@Composable
fun Greeting(name: String, context: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally // Aligns the children horizontally at the center
    ) {
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(16.dp)
        )
        PanicButton(
            onClick = { },
            context = context
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
    }
}
