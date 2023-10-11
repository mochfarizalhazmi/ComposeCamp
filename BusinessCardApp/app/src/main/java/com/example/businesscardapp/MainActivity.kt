package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Content(
                        painter = painterResource(R.drawable.android_logo),
                        contentDescription = "Android Logo",
                        title = "Jennifer Doe",
                        description = "Android Developer Extraordinaire",
                        phoneNumber = "+11 (123) 444 555 666",
                        accountId = "@AndroidDev",
                        email = "jen.doe@android.com",
                    )
                }
            }
        }
    }
}

@Composable
fun Content(
    painter: Painter,
    contentDescription: String,
    title: String,
    description: String,
    phoneNumber: String,
    accountId: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Surface(color = Color(0xFFD2E7D4)) {
        Box {
            ProfileInformation(
                painter = painter,
                contentDescription = contentDescription,
                title = title,
                description = description
            )
            ContactInformation(
                phoneNumber = phoneNumber,
                accountId = accountId,
                email = email
            )
        }
    }
}

@Composable
fun ProfileInformation(
    painter: Painter,
    contentDescription: String,
    title: String,
    description: String,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ProfilePicture(painter = painter, contentDescription = contentDescription)
        Title(text = title)
        Description(text = description)
    }

}

@Composable
fun ContactInformation(
    phoneNumber: String,
    accountId: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Column(
            verticalArrangement = Arrangement.Bottom,
            modifier = Modifier.fillMaxHeight()
        ) {
            ContactTile(icon = Icons.Default.Phone, text = phoneNumber)
            Spacer(modifier = Modifier.height(8.dp))
            ContactTile(icon = Icons.Default.Share, text = accountId)
            Spacer(modifier = Modifier.height(8.dp))
            ContactTile(icon = Icons.Default.Email, text = email)
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun ProfilePicture(painter: Painter, contentDescription: String, modifier: Modifier = Modifier) {
    Surface(
        color = Color(0xFF083041)
    ) {
        Image(
            painter = painter,
            contentDescription = contentDescription,
            modifier = modifier
                .width(150.dp)
                .height(150.dp)

        )
    }
}

@Composable
fun Title(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 45.sp,
        textAlign = TextAlign.Center,
        color = Color(0, 0, 0),
        modifier = modifier
    )
}

@Composable
fun Description(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        fontSize = 17.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        color = Color(0xFF036936),
        modifier = modifier
            .padding(bottom = 16.dp)
    )
}

@Composable
fun ContactTile(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row {
        Icon(
            imageVector = icon,
            contentDescription = "",
            tint = Color(0xFF036936),
            modifier = Modifier.size(size = 24.dp),
        )
        Text(
            text = text,
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = Color(0xFF036936),
            modifier = modifier
                .padding(
                    start = 16.dp,
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        Content(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "Android Logo",
            title = "Jennifer Doe",
            description = "Android Developer Extraordinaire",
            phoneNumber = "+11 (123) 444 555 666",
            accountId = "@AndroidDev",
            email = "jen.doe@android.com",
        )
    }
}