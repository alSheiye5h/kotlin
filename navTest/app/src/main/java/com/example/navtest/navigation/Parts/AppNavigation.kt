package com.example.navtest.navigation.Parts

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.navtest.navigation.Screens
import com.example.navtest.screens.Details
import com.example.navtest.screens.HomeScreen
import com.example.navtest.screens.ScreenA
import com.example.navtest.screens.ScreenB

fun NavGraphBuilder.AppGraph(navController : NavHostController) {
    navigation(route = Screens.AppRoute.route, startDestination = Screens.ScreenHomeRoute.route) {

        composable(route = Screens.ScreenHomeRoute.route) {
            HomeScreen(navController)
        }

        composable(route = Screens.ScreenARoute.route) {
            ScreenA(navController)
        }

        composable(route = Screens.ScreenBRoute.route) {
            ScreenB(navController)
        }

        composable(
            route = Screens.ScreenDetailsRoute.route,
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                },
                navArgument(name = "age") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            Details(
                navController = navController,
                name = backStackEntry.arguments?.getString("name"),
                age = backStackEntry.arguments?.getInt("age")
            )
        }

    }
}