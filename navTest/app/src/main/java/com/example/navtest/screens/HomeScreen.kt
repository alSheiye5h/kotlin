package com.example.navtest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.ui.text.input.KeyboardType
import com.example.navtest.navigation.Screens

@Composable
fun HomeScreen(navController: NavController) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green,
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Cursive
                        )
                    ){
                        append("H")
                    }
                    append("home ")
                    withStyle(
                        style = SpanStyle(
                            color = Color.Green,
                            fontSize = 42.sp,
                            fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily.Cursive
                        )
                    ) {
                        append("S")
                    }
                    append("creen")
                },
                color = Color.LightGray,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
            )

            Spacer(
                modifier = Modifier
                    .height(50.dp)
            )

            var nameTextField by remember { mutableStateOf("") }
            OutlinedTextField(
                label = {
                    Text("Your name")
                },
                value = nameTextField,
                onValueChange = { nameTextField = it}
            )

            Spacer(modifier = Modifier.height(20.dp))

            var ageTextField by remember { mutableStateOf("") } // Store as a String

            OutlinedTextField(
                label = { Text("Your Age") },
                value = ageTextField,
                onValueChange = { newValue ->
                    // Ensure only numeric input is allowed
                    if (newValue.all { it.isDigit() } || newValue.isEmpty()) {
                        ageTextField = newValue
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number) // Set keyboard to numeric
            )

            Spacer(modifier = Modifier.height(15.dp))

            Button(
                modifier = Modifier,
                shape = RoundedCornerShape(15.dp),
                onClick = {
                    // navController.navigate("details?name=$nameTextField&age=$ageTextField")
                    navController.navigate(Screens.ScreenDetailsRoute.withArgs(nameTextField, ageTextField.toInt()))

                }
            ) {
                Text("Send")
            }
        }
}

















