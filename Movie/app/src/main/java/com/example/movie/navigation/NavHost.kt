package com.example.movie.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.movie.Screens.BannerScreen
import com.example.movie.Screens.HomeScreen

@Composable
fun NavHost(
    navController: NavHostController = rememberNavController(),
    innerPadding: PaddingValues
    ) {

    NavHost (
        navController = navController,
        startDestination = "banner"
    ) {
        composable(route = "banner") {
            BannerScreen(navController, innerPadding)
        }

        composable(route = "home") {
            HomeScreen(navController)
        }

    }
}