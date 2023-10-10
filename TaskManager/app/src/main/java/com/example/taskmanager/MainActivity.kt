package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content(
                        painter = painterResource(id = R.drawable.ic_task_completed),
                        title = stringResource(R.string.title),
                        description = stringResource(R.string.description)
                    )
                }
            }
        }
    }
}

@Composable
fun LogoImage(painter: Painter) {
    Box {
        Image(
            painter = painter,
            contentDescription = null,
        )
    }
}

@Composable
fun Title(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .padding(
                top = 24.dp,
                bottom = 8.dp
            )
    )
}

@Composable
fun Description(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 16.sp
    )
}

@Composable
fun Content(
    painter: Painter,
    title: String,
    description: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LogoImage(painter = painter)
        Title(text = title)
        Description(text = description)
    }
}

@Preview(
    name = "Content",
    showBackground = true,
    showSystemUi = true
)

@Composable
fun ContentPreview() {
    TaskManagerTheme {
        Content(
            painter = painterResource(id = R.drawable.ic_task_completed),
            title = stringResource(R.string.title),
            description = stringResource(R.string.description)
        )
    }
}