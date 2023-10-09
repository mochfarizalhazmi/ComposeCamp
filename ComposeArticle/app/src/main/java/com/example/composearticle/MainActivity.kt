package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content(
                        painter = painterResource(id = R.drawable.bg_compose_background),
                        title = "Jetpack Compose tutorial",
                        firstParagraph = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                        secondParagraph = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
                    )
                }
            }
        }
    }
}

@Composable
fun HeaderImage(painter: Painter) {
    Box {
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
    }
}

@Composable
fun Title(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 24.sp,
        modifier = modifier
            .padding(16.dp)
    )
}

@Composable
fun FirstParagraph(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(start = 16.dp)
            .padding(end = 16.dp)
    )
}

@Composable
fun SecondParagraph(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        textAlign = TextAlign.Justify,
        modifier = modifier
            .padding(16.dp)
    )
}

@Composable
fun Content(
    painter: Painter,
    title: String,
    firstParagraph: String,
    secondParagraph: String,
    modifier: Modifier = Modifier
) {
    Column {
        HeaderImage(painter = painter)
        Title(text = title)
        FirstParagraph(text = firstParagraph)
        SecondParagraph(text = secondParagraph)
    }
}

@Preview(
    name = "Content",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ContentPreview() {
    ComposeArticleTheme {
        Content(
            painter = painterResource(id = R.drawable.bg_compose_background),
            title = "Jetpack Compose tutorial",
            firstParagraph = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
            secondParagraph = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."
        )
    }
}