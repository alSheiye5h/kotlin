package com.example.pizzarios.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzarios.R
import com.example.pizzarios.classes.Pizza


@Composable
fun DetailScreen(
    item: Pizza
) {

    val context = LocalContext.current
    val imageResId = context.resources.getIdentifier(item.image, "drawable", context.packageName)
    val imagePainter = if (imageResId != 0) { painterResource(id = imageResId) } else { painterResource(id = R.drawable.pizza1) }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box (
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = imagePainter,
                contentDescription = item.name,
                modifier = Modifier.clip(RoundedCornerShape(16.dp))
            )
        }
        Spacer(Modifier.height(20.dp))

        Text(
            text = item.name,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(15.dp))

        Text(
            text = item.description,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold
        )

    }

}























