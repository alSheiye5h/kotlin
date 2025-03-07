package com.example.navtest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navtest.R
import com.example.navtest.navigation.Screens

@Composable
fun ForgetPassword(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(
                    color = colorResource(id = R.color.forg),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold
                    )) {
                    append("F")
                }
                append("orget ")
                withStyle(SpanStyle(
                    color = colorResource(id = R.color.forg),
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Bold
                )) {
                    append("P")
                }
                append("assword")
            },
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        Spacer(Modifier.height(20.dp))

        var username: String by remember { mutableStateOf("") }
        OutlinedTextField(
            label = {
                Text("username")
            },
            value = username,
            onValueChange = {
                username = it
            },
        )

        Spacer(Modifier.height(8.dp))
        Button(
            modifier = Modifier,
            onClick = {
                // show a notif
            }
        ) {
            Text("Search")
        }

        Spacer(Modifier.height(15.dp))
        Text(
            text = "login",
            textDecoration = TextDecoration.Underline,
            color = Color.Black,
            fontSize = 12.sp,
            modifier = Modifier
                .clickable {
                    // navigate to login
                    navController.navigate(Screens.ScreenLoginRoute.route)
                }
        )
    }
}

















