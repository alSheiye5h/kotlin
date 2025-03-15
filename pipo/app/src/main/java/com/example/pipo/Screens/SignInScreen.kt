package com.example.pipo.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.pipo.R

@Composable
fun SignInScreen(navController: NavHostController, innerPadding: PaddingValues) {
    Image(
        painter = painterResource(id = R.drawable.login_blur),
        contentDescription = "backgroundImage",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
    )
    Column (
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(innerPadding.calculateTopPadding())) // set it for innerPadding

        Image(
            painter = painterResource(id = R.drawable.oig4__rndcloiljdx4hxpn),
            contentDescription = ""
        )

        Text(
            text = "PipoChat",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.ExtraBold),
            color = Color(0xFF101010),
            fontStyle = FontStyle.Italic
        )

        Text(
            text = "alShaye5h Got bored.",
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            color = Color(0xFF3b3b3b)
        )

        Spacer(Modifier.height(10.dp))


        val buttonBrush = Brush.linearGradient(
            listOf(
                Color(0xFF238CDD),
                Color(0xFF255DCC)
            )
        )

        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text("username") }
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("password") }
            )
        }
        Spacer(Modifier.height(10.dp))

        Text(
            text = "signup for free ",
            style = TextStyle(
                fontSize = 15.sp,
                color = Color.DarkGray,
                textDecoration = TextDecoration.Underline,
                textAlign = TextAlign.End,
            ),
            modifier = Modifier
                .fillMaxWidth(.7f)
                .clickable {
                    //signup click
                }
        )

        Spacer(Modifier.height(20.dp))

        val loginBrush = Brush.linearGradient(
            listOf(
                Color(0xFF55b9f2),
                Color(0xFF2399dd)
            )
        )

        Button(
            onClick = {
                navController.navigate("home")
            },
            modifier = Modifier
                .background(loginBrush, CircleShape)
                .fillMaxWidth(.7f)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            /* elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp, // Normal elevation
                pressedElevation = 4.dp, // When button is pressed
                disabledElevation = 0.dp  // When button is disabled
            ), */
        ) {
            Text(
                text = "Login",
                modifier = Modifier.padding(end = 20.dp),
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Icon(
                imageVector = Icons.TwoTone.ExitToApp,
                contentDescription = "loginLogo",
                modifier = Modifier.scale(1.5f),
                tint = Color.White
            )
        }
        Spacer(Modifier.height(10.dp))

        Button(
            onClick = {
                // navigate to ...
            },
            modifier = Modifier
                .background(buttonBrush, CircleShape)
                .fillMaxWidth(.7f)
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            /* elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp, // Normal elevation
                pressedElevation = 4.dp, // When button is pressed
                disabledElevation = 0.dp  // When button is disabled
            ), */
        ) {
            Text(
                text = "Continue With Google",
                modifier = Modifier.padding(end = 20.dp),
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
            )
            Image(
                painter = painterResource(id = R.drawable.goog_0ed88f7c),
                contentDescription = "googleLogo",
                modifier = Modifier.scale(1.2f)
            )
        }
    }
}













