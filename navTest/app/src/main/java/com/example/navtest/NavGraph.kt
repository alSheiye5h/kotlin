package com.example.navtest

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.navtest.screens.Details
import com.example.navtest.screens.HomeScreen

@Composable
fun Nav(navController: NavHostController, iner: PaddingValues) {

    NavHost(
        navController = navController,
        startDestination = "HomeScreen"
    ) {
        composable("HomeScreen") {
            HomeScreen(navController)
        }

        composable(
            route = "Details?name={name}&age={age}",
            arguments = listOf(
                navArgument(name = "name") {
                    type = NavType.StringType
                    defaultValue = "user"
                },
                navArgument(name = "age") {
                    type = NavType.IntType
                    defaultValue = 0
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


