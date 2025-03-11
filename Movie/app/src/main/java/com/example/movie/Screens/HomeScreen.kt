package com.example.movie.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.movie.R
import com.example.movie.models.Data
import com.example.movie.viewModel.ViewModel

@Composable
fun HomeScreen(navController: NavHostController) {
    val movieViewModel = viewModel<ViewModel>()
    val state = movieViewModel.state

    Scaffold (
        modifier = Modifier
            .background(Color.Transparent),
        topBar = {
            TopBar()
        },
        content = { paddingValue ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(paddingValue)
                    .fillMaxSize()
                    .background(
                        Color.Transparent
                    )
            ) {
                items(state.movies.size) {itemIndex ->
                    MovieCard(
                        itemIndex = itemIndex,
                        moviesList = state.movies,
                        navController = navController
                    )
                }
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MovieCard(itemIndex: Int, moviesList: List<Data>, navController: NavHostController) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(10.dp)
            .clip(RoundedCornerShape(15.dp))
            .clickable {

            },
        elevation = CardDefaults.cardElevation(8.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            AsyncImage(
                model = moviesList[itemIndex].poster,
                contentDescription = moviesList[itemIndex].title,
                modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop,
                )
            Column (
                modifier = Modifier
                    .background(Color.White.copy(.3f))
                    .padding(6.dp)
            ) {
                Text(
                    text = moviesList[itemIndex].title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .basicMarquee(),
                    textAlign = TextAlign.Center,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    style = TextStyle(
                        shadow = Shadow(
                            color = Color(0xFFFC5A03),
                            offset = Offset(2.0f, 2f),
                            blurRadius = 3f
                        ),
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.cinzel_decorative))
                    ),
                )

                Spacer(Modifier.height(8.dp))

                Row (
                    modifier = Modifier.align(Alignment.End),
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Star,
                        contentDescription = "",
                        tint = Color.Black,
                        )

                    Text(
                        text = moviesList[itemIndex].imdb_rating,
                        textAlign = TextAlign.Start,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp),
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        maxLines = 2
                    )

                }

            }

        }


    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(title = { Text(text =  "Movie App") })
}




















