package com.example.cotuit.slides

import android.annotation.SuppressLint
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState

class Slide10 {

    companion object{

        @SuppressLint("UnnecessaryComposedModifier")
        @Composable
        fun Slide(
            slideState: SlideState,
            dataClass: MyDataClass ?= null
        ){

            var slideTarget by remember { mutableStateOf((-400).dp) }

            if(slideState == SlideState.SLIDE_9){
                slideTarget = (-400).dp
            }

             if(slideState == SlideState.SLIDE_11){
                 slideTarget = 400.dp
             }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_10) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide10Animation finished") })

            val modifier0 = Modifier.background(Color.Black)
            val modifier1 = modifier0.fillMaxSize()
            val modifier2 = Modifier.fillMaxWidth(0.5f)
            val modifier3 = Modifier.fillMaxHeight(0.5f)
            val modifier4 = modifier0.composed { modifier2 }.composed { modifier3 }

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = slideAnimation, y = 0.dp)
                .background(Color(0xFF03A9F4))){

                Column{
                    Text("Slide #10 - Composed Modifiers",
                        color = Color(0xFF0923B4), fontSize = 21.sp, fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.background(Color(0xFFFFEB3B)))

                    Box(modifier = modifier4){
                        Text("Box(modifier = modifier4)", color = Color.White)
                    }

                    Text(" val modifier0 = Modifier.background(Color.Black)\n\n" +
                            "val modifier1 = modifier0.fillMaxSize() <- not used in this example\n\n" +
                            "val modifier2 = Modifier.fillMaxWidth(0.5f)\n\n" +
                            "val modifier3 = Modifier.fillMaxHeight(0.5f)\n\n" +
                            "val modifier4 = modifier0.composed { modifier2 }.composed { modifier3 }\n\n\n" +
                    "This demonstrates how modifiers can 'inherit' values in a other modifier objects, which is similar " +
                            "to how Cascading Style Sheets (CSS) work ")
                }




            }
        }

    }
}