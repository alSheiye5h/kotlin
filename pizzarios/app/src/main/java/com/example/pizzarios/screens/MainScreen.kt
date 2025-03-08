package com.example.pizzarios.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pizzarios.R
import com.example.pizzarios.classes.Pizza

@Composable
fun MainScreen(
    items: List<Pizza>,
    contentPadding: PaddingValues,
    navController: NavController
) {
    LazyColumn (
        contentPadding = contentPadding
    ) {
        val itemsCount = items.size

        items(itemsCount) {index ->
            ColumnItem(
                painter = items[index].image,
                name = items[index].name,
                description = items[index].description,
                itemIndex = index,
                navController = navController
            )
        }
    }
}



@Composable
fun ColumnItem(
    painter: String,
    description: String,
    name: String,
    itemIndex: Int,
    navController: NavController
) {
    val context = LocalContext.current
    val imageResId = context.resources.getIdentifier(painter, "drawable", context.packageName)

    val imagePainter = if (imageResId != 0) {
        painterResource(id = imageResId)
    } else {
        painterResource(id = R.drawable.pizza1)
    }

    Card (
        Modifier
            .padding(10.dp)
            .wrapContentSize()
            .clickable {
                navController.navigate(route = "DetailScreen?index=$itemIndex")
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp)
    ) {
        Row (
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier.size(140.dp).fillMaxHeight()
            )
            Column (
                Modifier.padding(16.dp),
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
                    fontSize = 14.sp,
                    color = colorResource(id = R.color.description),
                    lineHeight = 14.sp
                )
            }
        }
    }
}






























