package com.example.pizzarios.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.animations.screens.OnBoardingScreen
import com.example.navtest.screens.Details
import com.example.pizzarios.animationTest.SplachScreen


@Composable
fun Nav(navController: NavHostController, innerPadding: PaddingValues, context: Context) {
    NavHost(
        navController = navController,
        startDestination = "landing",
    ) {
        composable(route = "landing") {
            SplachScreen(navController = navController, context = context)
        }

        composable(
            route = "onBoarding",
        ) {
            OnBoardingScreen(navController = navController, context = context)
        }

        composable(route = "details") {
            Details(navController = navController)
        }
    }
}