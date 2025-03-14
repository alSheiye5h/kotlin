package com.example.messaging.Screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.messaging.Models.Conversation
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.messaging.viewModel.MessagingViewModel

var state = listOf(
    Conversation(1, "pizza1", "user1", "lastMessage1", "01/05/2000"),
    Conversation(2, "pizza2", "user2", "lastMessage2", "23/11/2020"),
    Conversation(3, "pizza3", "user3", "lastMessage3", "11/06/2024"),
    Conversation(4, "pizza4", "user4", "lastMessage4", "21/01/2003"),
)
@Composable
fun Landing(
    navController: NavHostController,
    innerPadding: PaddingValues
) {

    val messagingViewModel = viewModel<MessagingViewModel>()

    Scaffold (
        modifier = Modifier
            .padding(innerPadding),
        topBar = {
            TopBar(
                text = "Messaging",
                modifier = Modifier
                )
        },
        content = { paddingValues ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(1),
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(horizontal = 8.dp)
                    .padding(top = 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(state.size) {itemIndex ->
                    ConversationCard(item = state, itemIndex = itemIndex, padding = paddingValues, navController = navController)
                }
            }

        }
    )
}


@Composable
fun ConversationCard(
    itemIndex: Int,
    item: List<Conversation>,
    modifier: Modifier = Modifier,
    padding: PaddingValues,
    navController: NavHostController
) {

    ConstraintLayout (
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth()
            .border(1.dp, Color(219, 219, 219, 20), RoundedCornerShape(20.dp))
            .clickable {
                navController.navigate("conversation?id=${item[itemIndex].id}")
            },

    ) {
        val (image, username, message, date) = createRefs()

        // change to AsyncImage for API Call
        DynamicImage(item[itemIndex].image)?.let {
            Image(
                painter = it,
                contentDescription = "",
                modifier = Modifier
                    .constrainAs(image) {
                        start.linkTo(parent.start, margin = 15.dp)
                        centerVerticallyTo(parent)
                    }
                    .clip(CircleShape)
                    .size(50.dp),

            )
        }

        Text(
            text = item[itemIndex].username,
            modifier = Modifier
                .constrainAs(username) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(image.end, margin = 15.dp)
                },
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 1.sp,
            color = Color.White
            )

        Text(
            text = item[itemIndex].lastMessage,
            modifier = Modifier
                .constrainAs(message) {
                    top.linkTo(username.bottom, margin = 6.dp)
                    start.linkTo(image.end, margin = 15.dp)
                },
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Color.LightGray
        )

        Text(
            text = " • " + item[itemIndex].date,
            modifier = Modifier
                .constrainAs(date) {
                    top.linkTo(username.bottom, margin = 6.dp)
                    start.linkTo(message.end)
                },
            fontSize = 13.sp,
            fontWeight = FontWeight.Normal,
            color = Color.LightGray
        )

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(text: String, modifier: Modifier) {
    TopAppBar(
        title = { Text(text =  text, color = Color.White, fontStyle = FontStyle.Italic, fontWeight = FontWeight.Bold, letterSpacing = 1.sp) },
        modifier = modifier
            .background(Color.LightGray)
            .drawBehind {
                drawLine(
                    color = Color(219, 219, 219, 20), // Border color
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 2.dp.toPx()
                )
            }
        )
}

@Composable
fun getDrawableFromString(context: Context, drawableName: String): Painter? {
    val resourceId = remember(drawableName) {
        context.resources.getIdentifier(drawableName, "drawable", context.packageName)
    }
    return if (resourceId != 0) painterResource(id = resourceId) else null
}

@Composable
fun DynamicImage(drawableName: String, modifier: Modifier = Modifier): Painter? {
    val context = LocalContext.current
    val painter = getDrawableFromString(context, drawableName)

    return painter
}