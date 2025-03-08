package com.example.pizzeria.navigation

import android.content.Context
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.safe.args.generator.IntType
import com.example.pizzeria.Screens.DetailScreen
import com.example.pizzeria.Screens.MainScreen
import com.example.pizzeria.classes.Pizza
import com.example.pizzeria.classes.pizzas



@Composable
fun Nav(
    navController: NavHostController,
    paddingValues: PaddingValues,
    context: Context
) {
    var columnModifier = Modifier
    var itemsModifier = Modifier
    NavHost(
        navController = navController,
        startDestination = "MainScreen"
    ) {
        composable(route = "MainScreen") {
            MainScreen(
                items = pizzas,
                contentPadding = paddingValues,
                itemsModifier = itemsModifier,
                navController = navController,
            )
        }

        composable(
            route = "DetailScreen?index={index}&context={context}",
            arguments = listOf(
                navArgument(name = "index") {
                    type= NavType.IntType
                }
            )
        ) { args ->
            DetailScreen(
                pizzas[args.arguments?.getInt("index") ?: 0]
            )

        }
    }
}