package com.example.navtest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navtest.R
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun Register(navController: NavHostController) {
    Column (
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    SpanStyle(
                        color = colorResource(id = R.color.reg),
                        fontSize = 50.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("R")
                }
                append("egister ")
                withStyle(
                    SpanStyle(
                        color = colorResource(id = R.color.reg),
                        fontSize = 50.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("S")
                }
                append("creen")
            },
            color = Color.Black,
            fontSize = 30.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(15.dp))

        var emailRegister: String by remember { mutableStateOf("") }
        OutlinedTextField(
            label =  {
              Text("email")
            },
            value = emailRegister,
            onValueChange = {
                emailRegister = it
            }
        )

        Spacer(Modifier.height(8.dp))
        var usernameRegister: String by remember { mutableStateOf("") }
        OutlinedTextField(
            label = {
                Text("username")
            },
            value = usernameRegister,
            onValueChange = {
                usernameRegister = it
            }
        )

        Spacer(Modifier.height(8.dp))
        var passwordRegister by remember { mutableStateOf("") }
        var showPass by remember { mutableStateOf(false) }

        OutlinedTextField(
            label = {
                Text(text = "password")
            },
            value = passwordRegister,
            onValueChange = {
                passwordRegister = it
            },
            visualTransformation = if (showPass) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = {showPass = !showPass}) {
                    Icon(
                        painter = painterResource(
                            if (showPass) android.R.drawable.ic_menu_view
                            else android.R.drawable.ic_secure
                        ),
                        contentDescription = "toggle password"
                    )
                }
            }
        )

        Spacer(Modifier.height(8.dp))
        Button(
            onClick = {
                // navigate to home screen
            }
        ) {
            Text("sign up")
        }
        Spacer(Modifier.height(20.dp))
        Text(
            text = buildAnnotatedString {
                withStyle(SpanStyle(
                    fontSize = 12.sp,
                    color = Color.Black,
                    textDecoration = TextDecoration.None,
                )) {
                    append("already have an account?")
                }
                append("Login")
            },
            textDecoration = TextDecoration.Underline,
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier
                .clickable {
                    // navigate to login screen
                }
        )
    }
}




























