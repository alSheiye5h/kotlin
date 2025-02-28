package com.example.tryingtolivethedream

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tryingtolivethedream.ui.theme.TryingToLiveTheDreamTheme
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.tryingtolivethedream.domain.Post
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TryingToLiveTheDreamTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        SearchBar(
                            modifier = Modifier.padding(innerPadding)
                        )
                        ButtonSearch(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                    LazyColumn (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp)
                            .background(Color.White)
                            .border(5.dp, Color.White)
                    ) {


                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier) {

    var searchString: String by remember { mutableStateOf("") }
        TextField(
            value = searchString,
            onValueChange = {newT -> searchString = newT},
            label = {
                Text(text = "search a user")
            },
            modifier = Modifier.padding(16.dp).width(250.dp),

        )
}

@Composable
fun ButtonSearch(modifier: Modifier) {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(top = 16.dp)
            .height(60.dp)
            .width(170.dp)
    ) {
        AsyncImage(
            model = "file:///android_asset/lenssaa.png",
            contentDescription = "SVG Icon",
            modifier = Modifier.size(30.dp)
        )
    }
}

@Composable
fun PostItem(
    post: Post,
    onProfileClick: () -> Unit,
    onLikeClick: () -> Unit,
    onDislikeClick: () -> Unit,
    onCommentsClick: () -> Unit,
    onSaveClick: () -> Unit
) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            horizontalArrangement = Arrangement.Start, // Align children to the start (left)
        ) {
            AsyncImage(
                model = post.getUserProfile(),
                contentDescription = "profile",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable { post.gotoProfile() }
                ,
            )
            Spacer(modifier = Modifier.width(8.dp)) // Add spacing between image and text
            Text(
                text = post.username,
                modifier = Modifier.align(Alignment.CenterVertically) // Align text vertically
            )
    }

}























