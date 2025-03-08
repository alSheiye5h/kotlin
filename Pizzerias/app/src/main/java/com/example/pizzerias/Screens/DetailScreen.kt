package com.example.pizzeria.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzeria.classes.Pizza
import com.example.pizzerias.R

@Composable
fun DetailScreen(
    item: Pizza
) {

    val context = LocalContext.current
    val imageResId = context.resources.getIdentifier(item.image, "drawable", context.packageName)

    // Validate if the image resource exists
    val imagePainter: Painter = if (imageResId != 0) {
        painterResource(id = imageResId)
    } else {
        painterResource(id = R.drawable.pizza1) // Fallback image
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = imagePainter,
                contentDescription = item.name,
                Modifier.clip(RoundedCornerShape(16.dp))
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
            fontSize = 25.sp,
            fontWeight = FontWeight.SemiBold
        )
    }
}















