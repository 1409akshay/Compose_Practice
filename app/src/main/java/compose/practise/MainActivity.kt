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
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
            val list = arrayListOf<ListItemData>()
            list.add(ListItemData(R.drawable.icon, "Akshay kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Manoj kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Utkarsh kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Manohar kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Pradeep kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Vaibhav kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Abhinav kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Javed kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Ayush kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Kanish kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Tanuj kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Ankit kumar", "Senior Software Developer"))
            list.add(ListItemData(R.drawable.icon, "Umrao kumar", "Senior Software Developer"))

            //Recycler view of compose
            LazyColumn(content = {
                item {
                    list.map { i ->
                        showCardItem(img = i.img, title = i.title, subTitle = i.subTitle)
                    }
                }
            })


            //Non recyclable list which will create each item whether displayed on screen or not
            /*Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    list.map { item ->
                        showCardItem(img = item.img, title = item.title, subTitle = item.subTitle)
                    }
                }*/

            /*Column {
                showComposableViews()
                showCardItem()
                modifierExample()
            }*/


        }
    }

    @Composable
    private fun modifierExample() {
        Image(
            painter = painterResource(id = android.R.drawable.ic_delete),
            contentDescription = "",
            Modifier
                .clickable { }
                .size(200.dp)
                .border(2.dp, Color.Gray, CircleShape)
                .shadow(2.dp, RectangleShape, true, Color.Blue)
                .clip(CircleShape)

        )
    }

    @Composable
    private fun showCardItem(img: Int, title: String, subTitle: String) {
        Row(Modifier.clickable {
            Toast.makeText(this@MainActivity, title, Toast.LENGTH_SHORT).show()
        }) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "icon",
                Modifier
                    .size(100.dp)
                    .padding(10.dp, 10.dp),

                )
            Column {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(5.dp, 15.dp, 10.dp, 0.dp)
                )
                Text(
                    text = subTitle,
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

    data class ListItemData(val img: Int, val title: String, val subTitle: String)


}