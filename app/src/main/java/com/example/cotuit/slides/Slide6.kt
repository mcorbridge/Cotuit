package com.example.cotuit.slides

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState

class Slide6 {

    companion object{

        @Composable
        fun Slide(
            slideState: SlideState,
            dataClass: MyDataClass ?= null
        ){

            var slideTarget by remember { mutableStateOf((-400).dp) }
            var isPressed by remember { mutableStateOf(false) }
            var fooValue by remember { mutableStateOf("") }


            if(slideState == SlideState.SLIDE_5){
                slideTarget = (-400).dp
            }
            if(slideState == SlideState.SLIDE_7){
                slideTarget = 400.dp
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_6) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide6Animation finished") })

            BoxWithConstraints(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = slideAnimation, y = 0.dp)
                .background(Color(0xFF03A9F4))){

                Column{
                    Text("Slide #6 - Slot-based layouts")

                    if(isPressed){

                        Box{
                            Text("You pressed the 'FloatingActionButton'!",
                                fontFamily = FontFamily.Cursive, fontWeight = FontWeight.ExtraBold, color = Color.LightGray, fontSize = 46.sp,
                                modifier = Modifier.offset(2.dp, 2.dp))
                            Text("You pressed the 'FloatingActionButton'!",
                                fontFamily = FontFamily.Cursive, fontWeight = FontWeight.ExtraBold, color = Color.Blue, fontSize = 46.sp)
                        }
                    }
                    else{
                        Text("Press the 'FloatingActionButton'!",
                            fontFamily = FontFamily.Cursive, fontWeight = FontWeight.ExtraBold, color = Color.Yellow, fontSize = 40.sp)
                    }

                    Text(fooValue)
                }


                FloatingActionButton(modifier = Modifier.offset(x = this.maxWidth - 70.dp, y = this.maxHeight - 70.dp), onClick = {
                    println("FloatingActionButton ${System.currentTimeMillis()}")
                    isPressed = !isPressed
                }) {
                    Text("FAB")
                }


            }



        }
    }
}