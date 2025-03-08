package com.example.pizzarios.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.pizzarios.screens.DetailScreen
import com.example.pizzarios.screens.MainScreen
import pizzas

@Composable
fun Nav(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController = navController,
        startDestination = "MainScreen"
    ) {
        composable(route = "MainScreen") {
            MainScreen(
                items = pizzas,
                contentPadding = innerPadding,
                navController = navController
            )
        }

        composable(
            route = "DetailScreen?index={index}",
            arguments = listOf(
                navArgument(name = "index") {
                    type = NavType.IntType
                }
            )
            ) { args ->
            DetailScreen(
                item = pizzas[args.arguments?.getInt("index") ?: 0]
            )
        }
    }
}