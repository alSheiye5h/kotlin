package com.example.navtest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navtest.R
import com.example.navtest.navigation.Screens

@Composable
fun ScreenB(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                append("Screen")
                withStyle(
                    SpanStyle(
                        color = colorResource(id = R.color.purp),
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontFamily = FontFamily.Cursive
                    )
                ) {
                    append("B")
                }
            },
            fontSize = 30.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(
            modifier = Modifier.height(20.dp)
        )

        Text(
            text = "Go To Screen A",
            textDecoration = TextDecoration.Underline,
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier
                .clickable {
                    // navigate to screen a
                    navController.navigate(Screens.ScreenARoute.route)
                }
        )

        Spacer(
            modifier = Modifier.height(10.dp)
        )

        Text(
            text = "Go To Home screen",
            textDecoration = TextDecoration.Underline,
            color = Color.Red,
            fontSize = 12.sp,
            modifier = Modifier
                .clickable {
                    // navigate to home screen
                    navController.navigate(Screens.ScreenHomeRoute.route)
                }
        )
    }
}