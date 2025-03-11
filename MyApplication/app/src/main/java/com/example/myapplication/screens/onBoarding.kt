package com.example.myapplication.screens

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.myapplication.R
import com.example.myapplication.animations.LoaderAnimation
import com.example.myapplication.classes.screens
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun onBoarding(
    navController: NavHostController,
    context: Context
) {

    Column (
        modifier = Modifier.fillMaxSize().background(if (isSystemInDarkTheme()) { Color.DarkGray} else {Color.White}),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var pagerState = rememberPagerState(
            pageCount = screens.size
        )


        HorizontalPager(
            state = pagerState,
            modifier = Modifier.wrapContentSize()
        ) {currentScreen ->
            Column (
                modifier = Modifier.padding(16.dp).wrapContentSize().fillMaxHeight(0.7f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(screens[currentScreen].animation))
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(400.dp),
                )

                Spacer(Modifier.height(6.dp))
                Text(
                    text = screens[currentScreen].title,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = if (isSystemInDarkTheme()) { Color.White } else { Color.DarkGray },
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(12.dp))

                Text(
                    text = screens[currentScreen].description,
                    fontSize = 16.sp,
                    color = if (isSystemInDarkTheme()) { Color.White } else { Color.DarkGray },
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(8.dp))
                Pageindicator(
                    screensCount = screens.size,
                    modifier = Modifier.padding(60.dp),
                    currentScreen = currentScreen
                )

            }
            ButtonSection(
                pagerState = pagerState,
                screensCount = screens.size,
                context = context,
                modifier = Modifier
            )

        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ButtonSection(
    pagerState: PagerState,
    screensCount: Int,
    context: Context,
    modifier:Modifier
) {
    Box (
        modifier = modifier.fillMaxHeight(0.2f).fillMaxWidth().wrapContentSize(),
    ) {
        var color = if (isSystemInDarkTheme()) Color.White else Color.Black
        if (pagerState.currentPage != screensCount - 1) {

            var scope = rememberCoroutineScope()

            Text(
                text = "Back",
                color = color,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 40.dp)
                    .fillMaxWidth(0.3f)
                    .border(width = 1.dp, color = color, shape = RoundedCornerShape(10.dp))
                    .wrapContentHeight(Alignment.CenterVertically)
                    .clickable {
                        scope.launch {
                            if (pagerState.currentPage >= 0 && pagerState.currentPage <= 2 ) {
                                val prevPage = pagerState.currentPage - 1
                                pagerState.scrollToPage(prevPage)
                            }
                        }
                    },
                fontSize = 21.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Text(
                text = "Next",
                color = color,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 40.dp)
                    .fillMaxWidth(0.3f)
                    .border(width = 1.dp, color = color, shape = RoundedCornerShape(10.dp))
                    .wrapContentHeight(Alignment.CenterVertically)
                    .clickable {
                        scope.launch {
                            if (pagerState.currentPage >= 0 && pagerState.currentPage <= 2 ) {
                                val prevPage = pagerState.currentPage + 1
                                pagerState.scrollToPage(prevPage)
                            }
                        }
                    },
                fontSize = 21.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )
        } else {
            Button(
                onClick = {
                    val shardPreferences = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
                    val editor = shardPreferences.edit()
                    editor.putBoolean("isFinished", true)
                    editor.apply()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE92F1E), shape = RoundedCornerShape(10.dp))
                    .border(1.dp, color = Color.White, shape = RoundedCornerShape(10.dp))
                    .padding(bottom = 40.dp)
            ) {
                Text(
                    text = "Get Started!",
                    fontSize = 21.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = color
                )
            }
        }
    }
}



@Composable
fun Pageindicator(
    screensCount: Int,
    currentScreen: Int,
    modifier: Modifier
) {
    Row (
        horizontalArrangement = Arrangement.Center,
        modifier = modifier,
    ) {
        repeat(screensCount) {
            Indicator(isSelected = it == currentScreen)
        }
    }
}

@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 35.dp else 15.dp, label = "")
    Box(
        modifier = Modifier
            .padding(2.dp)
            .height(15.dp)
            .clip(CircleShape)
            .background(if (isSelected) Color(0xFFE92F1E) else Color.LightGray)
            .width(width.value)
    )
}























