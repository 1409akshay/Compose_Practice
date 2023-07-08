package compose.practise

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import compose.practise.ui.theme.ComposePractiseTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val random = Random.nextInt(0, 10)
            Toast.makeText(this, random.toString(), Toast.LENGTH_LONG).show()
            if (random < 5)
                printTitle(title = "Akshay kumar")
            else
                printMessage(title = "Message")
        }
    }

    @Composable
    fun printTitle(title: String) {
        Text(text = "Hey this is $title.")
    }

    @Composable
    fun printMessage(title: String) {
        Text(text = "Hey this is my $title.")
    }
}