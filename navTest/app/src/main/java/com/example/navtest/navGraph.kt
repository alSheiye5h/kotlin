package com.example.navtest

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Nav(innerpadding: PaddingValues) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "A", modifier = Modifier.padding(innerpadding)) {
        composable(route = "A") {
            ScreenA(navController)
        }
        composable(route = "B") {
            ScreenB(navController)
        }
        composable(route = "C") {
            ScreenC(navController)
        }
    }
}