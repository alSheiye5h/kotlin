package com.example.messaging.Navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavArgs
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.messaging.Screens.Conversation
// import com.example.messaging.Screens.chate
import com.example.messaging.Screens.Landing

@Composable
fun Nav(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "landing"
    ) {
        composable(
            route = "landing"
        ) {
            Landing(
                navController = navController,
                innerPadding = innerPadding
                )
        }

        composable(
            route = "conversation?id={id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.IntType
                }
            )
        ) {args ->
            Conversation(
                navController = navController,
                id = args.arguments?.getInt("id")!!,
                innerPadding = innerPadding
            )

        }
    }
}