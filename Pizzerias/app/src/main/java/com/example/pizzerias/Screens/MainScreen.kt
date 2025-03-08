package com.example.pizzeria.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pizzeria.classes.Pizza
import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pizzerias.R


@Composable
fun MainScreen(
    items: List<Pizza>,
    contentPadding: PaddingValues,
    navController: NavController,
) {
    LazyColumn(
        contentPadding = contentPadding
    )
    {
        val itemsCount = items.size

        items(itemsCount) { index ->
            ColumnItem(
                painter = items[index].image,
                description = items[index].description,
                name = items[index].name,
                itemsIndex = index,
                imageSize = items[index].imageSize,
                navController = navController
            )
        }
    }
}

@Composable
fun ColumnItem(
    modifier: Modifier = Modifier,
    painter: String,
    imageSize: Int,
    description: String,
    name: String,
    itemsIndex: Int,
    navController: NavController
    ) {

    val context = LocalContext.current
    val imageResId = context.resources.getIdentifier(painter, "drawable", context.packageName)

    // Validate if the image resource exists
    val imagePainter = if (imageResId != 0) {
        painterResource(id = imageResId)
    } else {
        painterResource(id = R.drawable.pizza1) // Fallback image
    }

    Card (
        modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                //navController.navigate(route = "DetailScreen?index=$itemsIndex")
            }
        ,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp),
    ) {
        Row (
            modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "null",
                modifier = Modifier.size(imageSize.dp).fillMaxHeight()
            )

            Column (
                modifier.padding(12.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = name,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Spacer(Modifier.height(10.dp))
                Text(
                    text = description,
                    fontSize = 19.sp,
                    color = colorResource(id = R.color.description),
                    lineHeight = 14.sp
                )
            }
            }
        }
    }



















