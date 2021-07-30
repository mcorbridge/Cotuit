package com.example.cotuit.slides

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState

class Slide11 {

    //@Inject
    //lateinit var testInject: TestInject <- no compile error, but doesn't get init'd

    companion object {


        @Composable
        fun Slide(
            slideState: SlideState,
            dataClass: MyDataClass? = null
        ) {

            var slideTarget by remember { mutableStateOf((-400).dp) }

            if (slideState == SlideState.SLIDE_10) {
                slideTarget = (-400).dp
            }

            // In preparation should a new slide be added to the slide deck
            // if(slideState == SlideState.SLIDE_12){
            //     slideTarget = 400.dp
            // }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_11) 0.dp else slideTarget,
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = 100f
                ),
                finishedListener = { println("slide11Animation finished") })

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .offset(x = slideAnimation, y = 0.dp)
                    .background(Color(0xFF03A9F4))
            ) {

                Column {
                    Text(
                        "Slide #11 - Hilt",
                        color = Color(0xFF0923B4),
                        fontSize = 21.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.background(Color(0xFFFFEB3B))
                    )

                    //testInject.TestNetwork() <- dinna works
                }
            }
        }
    }

}