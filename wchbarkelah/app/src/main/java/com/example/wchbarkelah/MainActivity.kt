package com.example.wchbarkelah

import android.content.Context
import android.media.Image
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.layoutId
import com.example.wchbarkelah.ui.theme.WchbarkelahTheme
import kotlinx.coroutines.launch
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.flowlayout.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowRow
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*WchbarkelahTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }*/
            // Allow the pulse rate to be configured, so it can be sped up if the user is running
// out of time
            LandingScreen({})
        }
    }
}

@Composable
fun LandingScreen(onTimeout: () -> Unit) {

    val splashWaitTimeMillis = 3000L // 3 seconds
    // This will always refer to the latest onTimeout function that
    // LandingScreen was recomposed with
    val currentOnTimeout by rememberUpdatedState(onTimeout)

    // Create an effect that matches the lifecycle of LandingScreen.
    // If LandingScreen recomposes, the delay shouldn't start again.
    LaunchedEffect(true) {
        delay(splashWaitTimeMillis)
        currentOnTimeout()
    }

    /* Landing screen content */
    Carder(0)
}
@Composable
fun ShowImageOnScroll() {
    val totalCount = 9
    var maxLines by remember { mutableStateOf(1) }
    val scrollState = rememberScrollState()
    val coroutineScope = rememberCoroutineScope()

    // Listen for scrolling to increase maxLines
    LaunchedEffect(scrollState.value) {
        if (scrollState.value > scrollState.maxValue * 0.8 && maxLines < totalCount) {
            maxLines += 1 // Expand items when user scrolls near the bottom
        }
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(scrollState)
            .pointerInput(Unit) {
                detectVerticalDragGestures { _, dragAmount ->
                    if (dragAmount < 0) { // User scrolls down
                        if (maxLines < totalCount) {
                            maxLines += 1
                        }
                    } else { // User scrolls up
                        if (maxLines > 1) {
                            maxLines -= 1
                        }
                    }
                }
            }
    ) {
        FlowRow(
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(totalCount.coerceAtMost(maxLines)) { index ->
                Carder(index)
            }
        }
    }
}

@Composable
fun Tester() {
    val totalCount = 9
    var maxLines by remember { mutableStateOf(1) }
    var scrollState = rememberScrollState()


    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .verticalScroll(scrollState)
    ) {
        FlowRow(
            mainAxisSpacing = 8.dp,
            crossAxisSpacing = 8.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            repeat(totalCount.coerceAtMost(maxLines)) { index ->
                Carder(index)
            }
        }

        Button(
            onClick = {
                maxLines = if (maxLines < totalCount) maxLines + 1 else 1
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(if (maxLines < totalCount) "Show More" else "Show Less")
        }
    }
}

@Composable
fun Carder(page: Int) {
    val context: Context = LocalContext.current
    val imageRes = getImageResId(context = context, "image$page")

    Card (
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer, RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .fillMaxHeight(0.3f),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box (
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(id =imageRes),
                contentDescription = "image"
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .fillMaxHeight()
                    .background(
                        Brush.verticalGradient(
                            0.65f to Color.Transparent,
                            0.3f to Color.Black
                        )
                    )
            )
            Box (
                modifier = Modifier.fillMaxSize().padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    text = "anyThing for objectif",
                    color = Color.White
                )
            }
        }

    }
}

@Composable
fun ChipItem(text: String) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.small,
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagesWithIndicator() {
    val pagerState = rememberPagerState(pageCount = {
        4
    })
    val context: Context = LocalContext.current

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        // Our page content
        val imageRes = getImageResId(context = context, "image$page")

        Image(
            painter = painterResource(id =imageRes),
            contentDescription = "image",
            modifier = Modifier.fillMaxWidth().height(200.dp)
        )
    }
    Row(
        Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.Bottom
    ) {
        repeat(pagerState.pageCount) { iteration ->
            val color = if (pagerState.currentPage == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp)
            )
        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager() {
    val pagerState = rememberPagerState(pageCount = {
        10
    })
    Column (
        Modifier.padding(top = 30.dp)
    ){
        HorizontalPager(state = pagerState) { page ->
            // Our page content
            Text(
                text = "Page: $page",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                color = Color.Black
            )
        }

// scroll to page
        val coroutineScope = rememberCoroutineScope()
        Button(
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(5)
                }
            },
        ) {
            Text("Scroll to Page 5")
        }
    }
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pagers() {
    val pagerState = rememberPagerState(pageCount = { 5 })
    Column {
        HorizontalPager(
            state = pagerState
        ) {page ->

            val context: Context = LocalContext.current
            val imageRes = getImageResId(context = context, "image$page")

            Image(
                painter = painterResource(id =imageRes),
                contentDescription = "image",
                modifier = Modifier.fillMaxWidth().height(200.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))

        val coroutineScope = rememberCoroutineScope()
        Button(
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(4)
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text("Scroll to Page 5")
        }
    }
}

fun getImageResId(context: Context, imageName: String): Int {
    return context.resources.getIdentifier(imageName, "drawable", context.packageName)
}



 @Composable
fun ConstLay() {
     ConstraintLayout (
         Modifier
             .fillMaxSize()
     ) {

         val (yellowBox, blueBox) = createRefs()
        Box (
            modifier = Modifier
                .background(Color.Yellow)
                .constrainAs(yellowBox) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    width = Dimension.value(100.dp)
                    height = Dimension.value(100.dp)
                }
        )
         Box (
             modifier = Modifier
                 .background(Color.Blue)
                 .constrainAs(blueBox) {
                     top.linkTo(parent.top)
                     start.linkTo(yellowBox.end)
                     width = Dimension.value(100.dp)
                     height = Dimension.value(100.dp)
                 }
         )
     }
}
