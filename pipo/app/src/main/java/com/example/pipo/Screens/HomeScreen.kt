package com.example.pipo.Screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController, innerPadding: PaddingValues) {
    val scaffoldBrush = Brush.linearGradient(
        listOf(
            Color(0xFF0a7fad),
            Color(0xFF0a36ad)
        )
    )
    Box (
        modifier = Modifier
            .fillMaxSize()
            .background(scaffoldBrush),
    ) {
        Scaffold (
            modifier = Modifier
                .fillMaxSize()
                // .padding(top = 45.dp), // set it to innerpadding
                .padding(top = innerPadding.calculateTopPadding() + 10.dp),
            containerColor = Color.Transparent,
            topBar = {
                val modifier = Modifier
                    .padding(horizontal = innerPadding.calculateStartPadding(LayoutDirection.Ltr) + 10.dp)
                TopAppBar(modifier)
            },
            bottomBar = {
                Row (
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    val entireScreenWithDp = LocalConfiguration.current.screenWidthDp.dp
                    NewMessage(Modifier.padding(bottom = LocalConfiguration.current.screenWidthDp.dp * 0.15f, end = 10.dp))
                }
            }
        ) {innerPadding ->
            val storymodifier = Modifier
                .padding(horizontal = innerPadding.calculateStartPadding(LayoutDirection.Ltr) + 10.dp) // set it to innerpadding
            contentApp(navController, innerPadding, storymodifier)

        }

    }
}

@Composable
fun NewMessage(modifier: Modifier) {
    IconButton(
        onClick =  {

        },
        modifier = modifier
            .size(60.dp)
            .background(Color(0xFF070d75), CircleShape)
            .clip(CircleShape),
    ) {
        Icon(
            imageVector = Icons.Filled.MailOutline,
            contentDescription = "",
            modifier = Modifier
                .size(40.dp)
        )
    }
}

@Composable
fun contentApp(navController: NavHostController, innerPadding: PaddingValues, storymodifier: Modifier) {
    Scaffold (
        modifier = Modifier.padding(top = innerPadding.calculateTopPadding()).fillMaxWidth()
        ,
        topBar = {
            StorySection(storymodifier)
        },
        containerColor = Color.Transparent
    ) {innerPadding ->
        Chat(navController, innerPadding)
    }
}

@Composable
fun Chat(navController: NavHostController, innerPadding: PaddingValues) {
    val brush = Brush.linearGradient(
        listOf(
            Color(0xFF0a7fad),
            Color(0xFF0a36ad)
        )
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = innerPadding.calculateTopPadding() + 10.dp)
            .background(Color(10, 54, 173, 70), RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp))  // this line is not working
    ) {
        Text(
            text = "Chat",
            style = TextStyle(
                color = Color.White,
                fontSize = 23.sp,
                fontWeight = FontWeight.SemiBold
            ),
            modifier = Modifier
                .padding(8.dp)
        )

    }
}

@Composable
fun StorySection(storymodifier: Modifier) {
    Box(
        modifier = storymodifier
            .size(62.dp) // Adjust the size of the circle
            .clip(CircleShape), // Clip the content to a circle,
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.matchParentSize()
        ) {
            val strokeWidth = 4.dp.toPx() // Border thickness
            val radius = size.minDimension / 2f
            val arcSize = Size(radius * 2, radius * 2)

            val totalSegments = 5
            val gapSize = 3.dp.toPx() // Convert dp to pixels
            val fullCircle = 360f
            val availableArc = fullCircle - (gapSize * totalSegments) // Available space after gaps
            val segmentAngle = availableArc / totalSegments // Angle per segment

            for (i in 0 until totalSegments) {
                drawArc(
                    color = Color.White,
                    startAngle = i * (segmentAngle + gapSize), // Position each segment
                    sweepAngle = segmentAngle, // Length of each segment
                    useCenter = false,
                    topLeft = Offset((size.width - arcSize.width) / 2, (size.height - arcSize.height) / 2),
                    size = arcSize,
                    style = Stroke(width = strokeWidth)
                )
            }
        }
        addStory()
    }
}


@Composable
fun addStory() {
    Box (
        modifier = Modifier
            .size(60.dp)
            .padding(4.dp)
            .background(Color(0, 0, 0, 150), CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
        )
    }
}




@Composable
fun TopAppBar(modifier: Modifier) {
    Row (
        modifier = modifier.fillMaxWidth()
    ) {
        Column (
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = "Hello,",
                style = TextStyle(
                    color = Color(0xFFdbdbdb),
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp
                )
            )
            Text(
                text = "thunder parend",
                style = TextStyle(
                    fontSize = 19.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            )
        }
        IconButton(
            modifier = Modifier
                .background(Color(0, 0, 0, 150), CircleShape)
                .size(40.dp),
            onClick = {

            }
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(35.dp)

            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        IconButton(
            modifier = Modifier
                .background(Color(0, 0, 0, 150), CircleShape)
                .size(40.dp),
            onClick = {

            }
        ) {
            Icon(
                imageVector = Icons.Filled.MoreVert,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier
                    .size(35.dp)

            )
        }
    }
}
