package com.example.pipo.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pipo.Screens.HomeScreen
import com.example.pipo.Screens.SignInScreen

@Composable
fun Nav(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "signin"
    ) {
        composable(
            route = "home"
        ) {
            HomeScreen(navController, innerPadding)
        }

        composable(
            route = "signin"
        ) {
            SignInScreen(navController, innerPadding)
        }


    }


}