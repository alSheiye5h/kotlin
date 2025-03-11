package com.example.pager

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pager.ui.theme.PagerTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PagerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PagerApp(innerPadding)
                }
            }
        }
    }
}

val pages = listOf(
    R.drawable.p1,
    R.drawable.p2,
    R.drawable.p3,
    R.drawable.p4,
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PagerApp(
    innerPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
        ) {
            val pagerState = rememberPagerState(
                pageCount = pages.size
            )
            LaunchedEffect(key1 = true) {
                while (true) {
                    delay(3000)
                    val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                    pagerState.scrollToPage(nextPage)
                }
            }
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(26.dp)
            ) {currentPage ->
                Column {
                    Card (
                        modifier = Modifier
                            .wrapContentSize(),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {
                        Image(
                            painter = painterResource(id = pages[currentPage]),
                            contentDescription = "",
                        )
                    }
                    PageIndicator(pagerState, currentPage)
                }
                SwapButtons(pagerState)
            }
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@SuppressLint("Range")
@Composable
fun SwapButtons(pagerState: PagerState) {
    Row (
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        val scope = rememberCoroutineScope()
        IconButton(
            onClick = {
                scope.launch {
                    if (pagerState.currentPage >= 1) {

                        val prevPage = (pagerState.currentPage - 1) % pagerState.pageCount
                        pagerState.scrollToPage(page = prevPage)
                    } else {
                        pagerState.scrollToPage(page = pagerState.pageCount - 1 )
                    }
                }
            },
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0, 0, 0, 50))
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowLeft,
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                tint = Color.LightGray
            )
        }

        IconButton(
            onClick = {
                scope.launch {
                        val nextPage = (pagerState.currentPage + 1) % pagerState.pageCount
                        pagerState.scrollToPage(page = nextPage)
                }
            },
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
                .background(Color(0, 0, 0, 50))
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                tint = Color.LightGray
            )
        }

    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun PageIndicator(
    pagerState: PagerState,
    currentPage: Int
) {
    Row (
        modifier = Modifier
            .padding(top = 20.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,

    ) {
        repeat(pagerState.pageCount) {current ->
            Indicator(isSelected = current == currentPage)
        }
    }
}


@Composable
fun Indicator(isSelected: Boolean) {
    val width = animateDpAsState(targetValue = if (isSelected) 35.dp else 15.dp)
        Box(
            modifier = Modifier
                .padding(2.dp)
                .clip(shape = CircleShape)
                .width(width.value)
                .height(15.dp)
                .background(color = if (isSelected) Color(183, 19, 189) else Color.LightGray)
        )
}

























