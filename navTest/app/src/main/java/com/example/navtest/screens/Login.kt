package com.example.navtest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.navtest.R
import kotlin.reflect.typeOf


@Composable
fun LoginScreen(navController: NavHostController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontStyle = FontStyle.Italic,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("L")
                }
                append("ogin ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Blue,
                        fontStyle = FontStyle.Italic,
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("S")
                }
                append("creen")
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

        Spacer(modifier = Modifier.height(10.dp))

        var password: String by remember { mutableStateOf("") }
        var passwordVisible by remember { mutableStateOf(false) }

        OutlinedTextField(
            label = {
                Text("password")
            },
            value = password,
            onValueChange = {
                password = it
            },
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        painter = painterResource(
                            if (passwordVisible) android.R.drawable.ic_menu_view
                            else android.R.drawable.ic_secure
                        ),
                        contentDescription = "Toggle Password Visibility"
                    )
                }
            },
        )
        Spacer(Modifier.height(7.dp))

        Text(
            text = "Forget Password",
            color = Color.Red,
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .clickable {
                    // navigate to forget password
                }
        )
        Spacer(Modifier.height(15.dp))

        Button(
            modifier = Modifier,
            onClick = {
                // navigate to home screen
            }
        ) {
            Text("sign in")
        }


        Spacer(Modifier.height(30.dp))

        Text(
            text = "Register",
            color = colorResource(id = R.color.reg),
            textDecoration = TextDecoration.Underline,
            modifier = Modifier
                .clickable {
                    // navigate to register
                }
        )
    }
}





























