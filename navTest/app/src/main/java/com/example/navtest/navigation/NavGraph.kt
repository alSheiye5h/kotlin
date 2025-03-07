package com.example.navtest.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.navtest.navigation.Parts.AppGraph
import com.example.navtest.navigation.Parts.AuthGraph
import com.example.navtest.screens.Details
import com.example.navtest.screens.ForgetPassword
import com.example.navtest.screens.HomeScreen
import com.example.navtest.screens.LoginScreen
import com.example.navtest.screens.Register
import com.example.navtest.screens.ScreenA
import com.example.navtest.screens.ScreenB

@Composable
fun Nav(navController: NavHostController, iner: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = Screens.AuthRoute.route
    ) {
        AuthGraph(navController)

        AppGraph(navController)
    }
}

