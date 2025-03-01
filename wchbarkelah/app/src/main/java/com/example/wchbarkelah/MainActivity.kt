package com.example.wchbarkelah

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.wchbarkelah.ui.theme.WchbarkelahTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /*WchbarkelahTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                }
            }*/
        }
    }
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