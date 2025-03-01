package com.example.waaaaaa

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.constraintlayout.compose.Dimension
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random.Default.nextFloat

import androidx.compose.material.ScaffoldState
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ConstraintLayout (
                modifier = Modifier.fillMaxSize()
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
    }
}


@Composable
fun ConstLay() {
    val contrainSet = ConstraintSet {
        val greenBox = createRefFor("greenBox")
        val redBox = createRefFor("redBox")

        constrain(greenBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }

        constrain(redBox) {
            top.linkTo(parent.top)
            start.linkTo(greenBox.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
    }

    ConstraintLayout (
        constraintSet = contrainSet,
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .background(Color.Yellow)
                .layoutId("greenBox")
        )
        Box (
            modifier = Modifier
                .background(Color.Blue)
                .layoutId("redBox")
        )
    }
}



@Composable
fun ItemsAreaLazyColumns() {

    var count = listOf("first", "second", "third", "fourth")
    LazyColumn (
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {

        // first way
        /*items(count) {i ->
            Text(
                text = "$i Item",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth().border(1.dp, Color.Black, RoundedCornerShape(10.dp)),
                textAlign = TextAlign.Center
            )
        }*/

        //second way
        itemsIndexed(
            listOf("first", "second", "third", "fourth")
        ) {index, string ->
            Text(
                text = "$index $string Item",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth().border(1.dp, Color.Black, RoundedCornerShape(10.dp)),
                textAlign = TextAlign.Center
            )
        }
    }



}

@Composable
fun ItemsAreaColumns() {
    val scrollState = rememberScrollState()

    Column (
        modifier = Modifier
            .verticalScroll(scrollState)
    ) {
        for (i in 1..50) {
            Text(
                text = "Item n*$i",
                fontSize = 24.sp,
                modifier = Modifier.fillMaxWidth().border(1.dp, Color.Black, RoundedCornerShape(10.dp)),
                textAlign = TextAlign.Center
             )
            Spacer(Modifier.height(3.dp))
        }
    }
}


@Composable
fun search(scaffoldState: ScaffoldState, scope: CoroutineScope) {
    Row (
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
    ) {

        var textValue by remember{ mutableStateOf("")}
        OutlinedTextField(
            value = textValue,
            onValueChange = { textValue = it},
            label = {
                Text("find Item")
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth(0.6f)
        )

        Button(
            modifier = Modifier.background(Color.White),
            onClick = {
                scope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(message = "looking $textValue")
                }
            }
        ) {
            Text("search")
        }
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    )
}

@Composable
fun ClickBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit
    ){
        Box(
            modifier = modifier
                .background(Color.White, RoundedCornerShape(16.dp))
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.1f)
                .clickable {
                    updateColor(
                        Color(
                            nextFloat(),
                            nextFloat(),
                            nextFloat(),
                            1f
                        )
                    )
                }
            .wrapContentSize(Alignment.Center) // Center the Box within its parent

        ) {
            Text("click to change color")
        }

    }

@Composable
fun SearchBar(placeHolder: String) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { newText -> text = newText },
        label = { Text(placeHolder) }
    )
}

@Composable
fun SearchButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .padding(start = 8.dp)
            .height(IntrinsicSize.Min) // Match the height of the TextField
    ) {
        Text("Search")
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier
) {
    Card(
        modifier = modifier
            .fillMaxHeight(0.3f)
            .fillMaxWidth(0.5f),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Box (
            modifier = Modifier
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier.fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            0.65f to Color.Transparent,
                            0.9999999999f to Color.Black
                        )
                    )
            )

            Box(
                modifier = Modifier.fillMaxSize().padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

@Composable
fun ImgeCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier
) {
    Card (
        modifier = modifier.fillMaxWidth(0.5f),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(5.dp)
    )
    {
        Box (
            modifier = Modifier.height(200.dp)
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier.fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                                0.65f to Color.Transparent,
                                0.9999999999f to Color.Black
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}


/*val scaffoldState = rememberScaffoldState()
           val scope = rememberCoroutineScope()

            Scaffold (
                modifier = Modifier
                    .padding(top = 20.dp)
                //    .fillMaxHeight(0.3f)
                ,
                scaffoldState = scaffoldState,
                topBar = {
                    search(scaffoldState, scope)
                }
            ) {i ->
                Box (
                    modifier = Modifier.padding(i).fillMaxSize()
                ) {
                    ItemsAreaLazyColumns()

                }

            }
                caffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column (
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {

                        Row (
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically // Ensures all items in the row are centered vertically
                        ) {
                            SearchBar("search for")
                            SearchButton()
                        }
                        Spacer(modifier = Modifier.height(8.dp))

                        Box(
                            Modifier.fillMaxHeight(0.05f)
                        ) {
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.Green,
                                            fontSize = 42.sp
                                        )
                                    ){
                                        append("S")
                                    }
                                    append("pacer")
                                },
                                color = Color.White,
                                fontSize = 30.sp,
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.Center,
                                textDecoration = TextDecoration.Underline
                            )
                        }
                        Spacer(modifier = Modifier.height(18.dp))
                        val color = remember {
                            mutableStateOf(Color.Yellow)
                        }
                        ColorBox(
                            Modifier.fillMaxWidth().fillMaxHeight(0.3f).background(color.value)
                        )
                        Spacer(modifier = Modifier.height(18.dp))
                        ClickBox(
                            modifier = Modifier
                        ) {
                            color.value = it
                        }



                        }
                        BoxWithConstraints {
                            val elementHeight = maxHeight * 0.5f // 10% of screen height
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .fillMaxHeight()
                            ) {
                                val painter = painterResource(id = R.drawable.cov)

                                ImageCard(
                                    painter = painter,
                                    contentDescription = "imageCard",
                                    title = "a title for image card",
                                    modifier = Modifier
                                )
                            }
                        }
                    }
                }*/























