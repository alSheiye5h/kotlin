package com.example.tryingtolivethedream

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
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
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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























