package com.example.tutorialcompose_01

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.PreviewActivity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorialcompose_01.ui.theme.TutorialCompose_01Theme
private  val message: List<MyMessage> = listOf(
    MyMessage("Ensayo 1","Error"),
    MyMessage("Ensayo 2","Error"),
    MyMessage("Ensayo 3","Error"),
    MyMessage("Ensayo 4","Error"),
    MyMessage("Ensayo 5","Error"),
    MyMessage("Ensayo 6","Error"),
    MyMessage("Ensayo 7","Error"),
    MyMessage("Ensayo 8","Error"),
    MyMessage("Ensayo 9","Error"),
    MyMessage("Ensayo 10","Error"),
    MyMessage("Ensayo 11","Error"),
    MyMessage("Ensayo 10","Error"),
    MyMessage("Ensayo 10","Error"),
    MyMessage("Ensayo 10","Error"),

)
class MainActivity :
    ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Elementos composable
            //OPCION 1 [NO FUNCIONAL]: Text("Hola! Elementos Composables aqui dentro")
            //OPCION 2: se puede poner tantas veces como quieras.
            //Text("Bienvenido")
            //OPCION 2: MyImage()
            //OPCION 2: MyTexts()
            //OPCION 3: [TOD0 DENTRO DE LA FUN MYCOMPONENT]
            //OPCION:3 MyComponent()
            //OPCION THEME
            /*Tema general de la app*/
            TutorialCompose_01Theme() {
                MyMessages(message)
            }
        }
    }
}
//Objeto para englobar dos parametros de Mytext por cada vez que lo llame
data class MyMessage(val title: String,val body: String)

//Añadimos un mensaje para lazycolumn
@Composable
fun MyMessages(message: List<MyMessage>){
    LazyColumn {
        items(message){message ->
            MyComponent(message)
        }
    }

}

//Añadimos una fila(ROW)
@Composable
fun MyComponent(message: MyMessage){
    Row(modifier = Modifier
        .background(MaterialTheme.colorScheme.background)
        .padding(8.dp)

    ) {
        MyImage()
        MyTexts(message)
    }
}

//Introducir imagenes Usaremos un painterResource
@Composable
fun MyImage(){
    Image(
    painterResource(R.drawable.ic_launcher_foreground),
        "Imagen de prueba",
        modifier = Modifier
            .size(64.dp) /*Usando un núymero lo proporciona*/
            .clip(CircleShape) /*Forma de la imagen en primer plano si no el círculo no se ve*/
            .background(MaterialTheme.colorScheme.primary)/*Color de fondo de la imagen (segundo plano)*/
            )
}

//@Composable => Elemento gráfico que se va a poder reutilizar, pintar, etc.
@Composable
fun MyText(text: String, color: Color, style: TextStyle){
    Text(text, color = color, style = style)
}

@Composable
//Esta función sin parámetros. Añadimos una columna para que salga el texto alineado en UNA columna
fun MyTexts(message: MyMessage){
    Column(modifier = Modifier
        .padding(start = 8.dp)/*Aqui crea una separación entre imagen
    y texto, por que lo inicia en la columna de mytexts */
    ){
        MyText(message.title,
            MaterialTheme.colorScheme.primary, /*Varias maneras de seleccionar color OPCION 1*/
            MaterialTheme.typography.titleLarge /*Modificacion del tipo de letra en el titulo*/
            )
        Spacer(modifier = Modifier
            .height(8.dp))/*Aqui añades un espacio en blanco  entre los dos textos*/

        MyText(message.body,
            MaterialTheme.colorScheme.onBackground,/*Varias maneras de seleccionar color OPCION 2*/
            MaterialTheme.typography.titleSmall /*Modificacion del tipo de letra en el titulo*/
        )
    }
}


@Preview(showSystemUi = true)/*Modo por defecto + modo preview movil*/
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES) /*Modo oscuro*/
@Composable
fun PreviewComponent() {
    TutorialCompose_01Theme() {

        /*val scrollState = rememberScrollState() *//*Creamos variable para el scroll*//*

        Column(modifier = Modifier
            .verticalScroll(scrollState)){
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
        }*/
        MyMessages(message)
    }
}