package com.example.cotuit.slides

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cotuit.test.SlideState

class Slide1 {

    companion object{

        @Composable
        fun Slide(slideState: SlideState, slideTarget: Dp, currentSlide: Int, direction: String){

            if(currentSlide == 1){
                println("currentSlide is Slide ONE")
                if(direction == "NEXT"){
                    println("slide direction --->")
                }else{
                    println("<--- slide direction")
                }
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_1) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide1Animation finished") })

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = slideAnimation, y = 0.dp)
                .background(Color(0xFF03A9F4))){
                Text("Slide #1 ")
            }
        }
    }
}