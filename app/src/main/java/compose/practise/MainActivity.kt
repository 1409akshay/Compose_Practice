package compose.practise

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            showComposableViews()


        }
    }

    @Composable
    fun showComposableViews() {
        Column {
            Text(text = "Hey this is my Image.")
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "DummyImage",
                Modifier.background(color = Color.Blue)
            )
            Button(onClick = {
                clickEvent()
            }) {
                Text(text = "Click Me")
            }
            val state = remember { mutableStateOf("") }
            TextField(
                value = state.value, onValueChange = {
                    state.value = it
                    Log.i("9090990", "showComposableViews: $it")
                }
            )
        }

    }

    private fun clickEvent() {
        val random = Random.nextInt(0, 20)
        Toast.makeText(this@MainActivity, "Clicked $random", Toast.LENGTH_SHORT).show()
    }
}