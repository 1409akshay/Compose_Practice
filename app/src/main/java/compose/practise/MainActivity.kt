package compose.practise

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                showComposableViews()
                showCardItem()
                modifierExample()
            }
        }
    }

    @Composable
    private fun modifierExample() {
        Image(
            painter = painterResource(id = android.R.drawable.ic_delete),
            contentDescription = "",
            Modifier
                .clickable {  }
                .size(200.dp)
                .border(2.dp, Color.Gray , CircleShape)
                .shadow(2.dp, RectangleShape, true, Color.Blue)
                .clip(CircleShape)

        )
    }

    @Composable
    private fun showCardItem() {
        Row {
            Image(
                painter = painterResource(id = R.drawable.icon),
                contentDescription = "icon",
                Modifier
                    .size(100.dp)
                    .padding(10.dp, 10.dp),

                )
            Column {
                Text(
                    text = "Akshay kumar",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(5.dp, 15.dp, 10.dp, 0.dp)
                )
                Text(
                    text = "Android Application Developer",
                    fontSize = 14.sp,
                    modifier = Modifier.padding(5.dp, 5.dp, 10.dp, 0.dp)
                )
            }
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