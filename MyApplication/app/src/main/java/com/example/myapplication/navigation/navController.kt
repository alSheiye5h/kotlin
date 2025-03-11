package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.animations.SplachScreen
import com.example.myapplication.screens.onBoarding


@Composable
fun Nav(
    navController: NavHostController
) {

    NavHost(
        navController = navController,
        startDestination = "onBoarding"
    ) {
        composable(route = "onBoarding") {
            val context = LocalContext.current
            onBoarding(
                navController,
                context
            )
        }

        composable(route = "splach") {
            SplachScreen(navController)
        }

    }
}