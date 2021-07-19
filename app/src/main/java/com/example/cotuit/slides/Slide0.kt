package com.example.cotuit.slides

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideDirection
import com.example.cotuit.test.SlideState

class Slide0 {

    companion object{

        @Composable
        fun Slide(slideState: SlideState, direction: SlideDirection, dataClass: MyDataClass ?= null){

            var slideTarget by remember { mutableStateOf((0).dp) }

            if(slideState == SlideState.SLIDE_0){
                println("currentSlide is Slide Zero")
                if(direction == SlideDirection.SLIDE_NEXT){
                    println("slide direction --->")
                    slideTarget = (-400).dp
                }else{
                    println("<--- slide direction")
                    slideTarget = 400.dp
                }
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_0) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide0Animation finished") })

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = slideAnimation, y = 0.dp)
                .background(Color(0xFF03A9F4))){
                Text("How to add a new slide\n\n (1) Create a new slide by copying this one\n" +
                        "(2) Create a 'slideTarget' var based on the naming pattern in 'SlideShow'\n" +
                        "(3) Create a unique 'animateDpAsState' using the same naming pattern in 'SlideShow'\n" +
                        "(4) Update '<previous' & 'next>' to provide navigation to the slide\n" +
                        "(5) Update 'enum class SlideState' with a new reference ")
            }
        }
    }
}