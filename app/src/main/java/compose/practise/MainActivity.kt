package compose.practise

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import compose.practise.ui.theme.ComposePractiseTheme
import kotlin.random.Random

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
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Button",
                )
            }
        }

    }

    private fun clickEvent() {
        val random = Random.nextInt(0, 20)
        Toast.makeText(this@MainActivity, "Clicked $random", Toast.LENGTH_SHORT).show()
    }
}