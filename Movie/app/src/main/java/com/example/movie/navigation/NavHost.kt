package com.example.movie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavHost(navController: NavHostController = rememberNavController()) {

    NavHost (
        navController = navController,
        startDestination = "banner"
    ) {
        composable(route = "banner") {
            BannerScreen()
        }

        composable(route = "home") {

        }

    }
}