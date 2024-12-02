package com.example.compra

import android.content.res.Configuration
import android.media.Image
import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compra.ui.theme.CompraTheme

private  val message: List<String> = listOf(
    "Producto 1",
    "Producto 2",
    "Producto 3",
    "Producto 4",
    "Producto 5",
    "Producto 6",
    "Producto 7",
    "Producto 8",
    "Producto 9",
    "Producto 10",
    "Producto 11",
    "Producto 12",
    "Producto 12+1",
    "Producto 14"
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme() {
                MyText("Version 1.0", Color.Black, TextStyle.Default)
            }
        }
    }
}

@Composable
fun lista(){
    LazyColumn(modifier = Modifier.padding(16.dp)){
        item { row()
            }
       items(message){ message->
           Text(message)
       }
    }
}
@Composable
fun row(){
    Row(
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Text("Añade un elemento:")
        IconButton(onClick = {}) {
            Icon(imageVector = Icons.Default.Add,
                contentDescription = "Añadir")
        }
    }
}


@Composable
fun MyText(text: String, color: Color,style: TextStyle) {
    Text(text,color= color,style=style)
}




@Preview(showSystemUi = true)
/*@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)*/
@Composable
fun Previsualizacion() {
    CompraTheme {
       lista()
    }
}