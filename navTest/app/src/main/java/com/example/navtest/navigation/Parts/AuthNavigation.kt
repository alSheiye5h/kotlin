package com.example.navtest.navigation.Parts

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.navtest.navigation.Screens
import com.example.navtest.screens.ForgetPassword
import com.example.navtest.screens.LoginScreen
import com.example.navtest.screens.Register

fun NavGraphBuilder.AuthGraph(navController: NavHostController) {
    navigation(startDestination = Screens.ScreenLoginRoute.route, route = Screens.AuthRoute.route) {

        composable(route = Screens.ScreenLoginRoute.route) {
            LoginScreen(navController)
        }

        composable(route = Screens.ScreenRegisterRoute.route) {
            Register(navController)
        }

        composable(route = Screens.ScreenForgetPassRoute.route) {
            ForgetPassword(navController)
        }

    }
}