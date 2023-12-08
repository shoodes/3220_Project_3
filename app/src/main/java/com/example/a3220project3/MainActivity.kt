package com.example.a3220project3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a3220project3.ui.theme._3220Project3Theme
import androidx.compose.animation.core.tween

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _3220Project3Theme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    var imageResource by remember { mutableStateOf(R.drawable.ic_launcher_foreground) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        // buttonColors
        val buttonColors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )

        // Button for A
        Button(
            onClick = { imageResource = R.drawable.red_image },
            colors = buttonColors,
            modifier = Modifier.padding(bottom = 15.dp)
        ) {
            Text("A")
        }

        // Button for B
        Button(
            onClick = { imageResource = R.drawable.green_image },
            colors = buttonColors,
            modifier = Modifier.padding(bottom = 15.dp)
        ) {
            Text("B")
        }

        // Button for C
        Button(
            onClick = { imageResource = R.drawable.blue_image },
            colors = buttonColors,
            modifier = Modifier.padding(bottom = 15.dp)
        ) {
            Text("C")
        }

        // Image with crossfade transition
        Crossfade(targetState = imageResource, animationSpec = tween(durationMillis = 1000)) { targetImage ->
            Image(
                painter = painterResource(id = targetImage),
                contentDescription = "Colored image",
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    _3220Project3Theme {
        MyApp()
    }
}
