package com.example.movie.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.movie.R

@Composable
fun BannerScreen(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    Box (
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner_image),
            contentDescription = "",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column (
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color(50, 50, 50, 150), RoundedCornerShape(30.dp))
                .padding(bottom = 100.dp)
                .clip(shape = RoundedCornerShape(30.dp))
                .border(1.dp, Color.Black, RoundedCornerShape(30.dp)),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "ENJOY THE WORLD OF MOVIES",
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                style = TextStyle(
                    fontSize = 34.sp,
                    shadow = Shadow(
                        color = Color(0xFFFC5A03),
                        offset = Offset(3.0f, 3f),
                        blurRadius = 3f
                    ),
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily(Font(R.font.cinzel_decorative))
                ),
                modifier = Modifier
                    .padding(16.dp)
            )

            val linearGradientBrush = Brush.linearGradient(
                colors = listOf(
                    Color(0xFFB226E1),
                    Color(0xFFFC6603),
                    Color(0xFF5995EE),
                    Color(0xFF3D3535)
                ),
                start = Offset(0f, 0f),
                end = Offset.Infinite
            )

            Button(
                onClick = {
                    navController.navigate("home")
                },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .background(Color(255, 255, 255, 50), RoundedCornerShape(20.dp))
                    .border(BorderStroke(
                        3.dp,
                        linearGradientBrush
                    ), RoundedCornerShape(20.dp)),
                shape = RoundedCornerShape(20.dp),
                colors = buttonColors(
                    Color(0, 0, 0, 50)
                )
            ) {
                Text(
                    text = "GET IN",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    style = TextStyle(
                        fontSize = 34.sp,
                        textAlign = TextAlign.Center,
                        fontFamily = FontFamily(Font(R.font.cinzel_decorative)),
                    )
                )
            }
        }
    }

}

























