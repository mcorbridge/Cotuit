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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideDirection
import com.example.cotuit.test.SlideState

class Slide8 {

    companion object{

        @Composable
        fun Slide(
            slideState: SlideState,
            direction: SlideDirection,
            dataClass: MyDataClass ?= null
        ){

            var slideTarget by remember { mutableStateOf((-400).dp) }

            if(slideState == SlideState.SLIDE_8){
                println("currentSlide is Slide EIGHT")
                if(direction == SlideDirection.SLIDE_NEXT){
                    println("slide direction --->")
                    slideTarget = (-400).dp
                }else{
                    println("<--- slide direction")
                    slideTarget = 400.dp
                }
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_8) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide8Animation finished") })

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = slideAnimation, y = 0.dp)
                .background(Color(0xFF03A9F4))){
                Column{
                    Text("Slide #8")
                    Text("${dataClass?.name} ${dataClass?.value}")
                }

            }
        }
    }
}