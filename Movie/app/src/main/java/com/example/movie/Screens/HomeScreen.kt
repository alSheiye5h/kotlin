package com.example.movie.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
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

            }
        }

    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(title = { Text( text =  "Movie App") })
}