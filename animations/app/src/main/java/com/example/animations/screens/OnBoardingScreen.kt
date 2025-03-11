package com.example.animations.screens

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.animations.R
import com.google.accompanist.pager.ExperimentalPagerApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavHostController,
    context: Context
) {
    val screens = listOf(
        Intro(R.raw.intro1, "Explore the skies", "discover unbeatable deals on air travel to destinations around the globe"),
        Intro(R.raw.intro2, "Escape to Paradise", "Unwind in breathtaking destinations with exclusive vacation"),
        Intro(R.raw.intro3, "Journey Beyond", "Embark on unforgettable adventures to the world's most iconic landmarks and")
    )

    Column (
        Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var pagerState = rememberPagerState (
            pageCount = { screens.size }
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.wrapContentSize()
        ) {currentPage ->
            Column (
                Modifier
                    .wrapContentSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(screens[currentPage].animation))
                LottieAnimation(
                    composition = composition,
                    iterations = LottieConstants.IterateForever,
                    modifier = Modifier.size(400.dp),
                )

                Text(
                    text = screens[currentPage].title,
                    textAlign = TextAlign.Center,
                    fontSize = 34.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = screens[currentPage].description,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(top = 45.dp)
                )
                PageIndicator(
                    ScreensCount = screens.size,
                    currentScreen = pagerState.currentPage,
                    modifier = Modifier.padding(60.dp)
                )
            }

        }
        ButtonsSection(
            pagerState = pagerState,
            navController = navController,
            context = context
        )
    }

}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ButtonsSection(
    pagerState: PagerState,
    navController: NavHostController,
    context: Context
) {
    val scope = rememberCoroutineScope()
    Box (
        modifier = Modifier.fillMaxSize().padding(30.dp),
    ) {
        if (pagerState.currentPage != 2) {
            Text(
                text = "Next",
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 40.dp)
                    .fillMaxWidth(0.3f)
                    .border(width = 1.dp, color = Color.White,shape = RoundedCornerShape(10.dp))
                    .wrapContentHeight(Alignment.CenterVertically)
                    .height(40.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .clickable {
                        scope.launch {
                            if (pagerState.currentPage >= 0 && pagerState.currentPage <= 1 ) {
                                val nextPage = pagerState.currentPage + 1
                                pagerState.scrollToPage(nextPage)
                            }
                        }
                    },
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Back",
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(bottom = 40.dp)
                    .fillMaxWidth(0.3f)
                    .border(width = 1.dp, color = Color.White,shape = RoundedCornerShape(10.dp))
                    .wrapContentHeight(Alignment.CenterVertically)
                    .height(40.dp)
                    .wrapContentHeight(Alignment.CenterVertically)
                    .clickable {
                        scope.launch {
                            if (pagerState.currentPage >= 0 && pagerState.currentPage <= 1 ) {
                                val prevPage = pagerState.currentPage - 1
                                pagerState.scrollToPage(prevPage)
                            }
                        }
                    },
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        } else {
            OutlinedButton(
                onClick = {
                    finishOnBoarding(context = context)
                    navController.popBackStack()
                    navController.navigate("details")
                },
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter).padding(bottom = 40.dp).height(40.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE92F1E)
                )
            ) {
                Text(
                    text = "Get Started",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,

                )
            }
        }
    }
}

@Composable
fun PageIndicator(
    ScreensCount: Int,
    currentScreen: Int,
    modifier: Modifier
) {
    Row (
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        repeat(ScreensCount) {
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
            .width(width.value)
            .clip(CircleShape)
            .background(if (isSelected) Color(0xFFE92F1E) else Color(0x25E92F1E))
    )
}

fun finishOnBoarding(context: Context) {
    val sharedPreferences = context.getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putBoolean("isFinished", true)
    editor.apply()
}







