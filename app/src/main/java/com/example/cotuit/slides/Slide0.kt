package com.example.cotuit.slides

import android.app.Application
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cotuit.hilt.TestFoo
import com.example.cotuit.hilt.TestInject
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class Slide0
    @Inject
    constructor(){


    companion object {

        @Composable
        fun Slide(slideState: SlideState, dataClass: MyDataClass ?= null){

            var slideTarget by remember { mutableStateOf(0.dp) }

            // Read this as NOT! where SLIDE_1 goes, but where SLIDE_0 goes when SLIDE_0 is currently
            // visible.
            // Only 'next>' (in this case SLIDE_1) can be pressed as '<previous' is not
            // an option since SLIDE_0 is the first slide.
            if(slideState == SlideState.SLIDE_1){
                slideTarget = (400).dp
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_0) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide0Animation finished") })

            Column{

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
}