package com.example.cotuit.test

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cotuit.menu.NavIcon

class SlideShow {

    companion object{

        @Composable
        fun DoSlideShow(navController: NavHostController) {


            var xPos by remember { mutableStateOf(10.dp) }
            val yPos by remember { mutableStateOf(10.dp) }
            var menuClick by remember { mutableStateOf(0) }
            var slideState by remember { mutableStateOf(SlideState.SLIDE_0) }
            var slide1Target by remember { mutableStateOf((-400).dp) }

            val slide0Animation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_0) 0.dp else 400.dp,
                animationSpec = tween(1000),
                finishedListener = { println("slide0Animation finished") })

            val slide1Animation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_1) 0.dp else slide1Target,
                animationSpec = tween(1000),
                finishedListener = { println("slide1Animation finished") })

            val slide2Animation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_2) 0.dp else (-400).dp,
                animationSpec = tween(1000),
                finishedListener = { println("slide2Animation finished") })

            val slide3Animation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_3) 0.dp else 400.dp, // TODO
                animationSpec = tween(1000),
                finishedListener = { println("slide3Animation finished") })

            val slide4Animation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_4) 0.dp else 400.dp, // TODO
                animationSpec = tween(1000),
                finishedListener = { println("slide4Animation finished") })

            val slide5Animation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_5) 0.dp else (-400).dp, // TODO
                animationSpec = tween(1000),
                finishedListener = { println("slide5Animation finished") })


            BoxWithConstraints(modifier = Modifier.fillMaxSize().background(Color(0xFF0778AC))) {

                Column{
                    // allow navigation back to Main Menu
                    NavIcon.MenuIcon(navController = navController)

                    BoxWithConstraints() {

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .offset(x = slide0Animation, y = yPos)
                            .background(Color(0xFF03A9F4))){
                            Text("slide 0")
                        }

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .offset(x = slide1Animation, y = yPos)
                            .background(Color(0xFFBAC550))){
                            Text("slide 1")
                        }

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .offset(x = slide2Animation, y = yPos)
                            .background(Color(0xFFE7DD82))){
                            Text("slide 2")
                        }

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .offset(x = slide3Animation, y = yPos)
                            .background(Color(0xFFD53B30))){
                            Text("slide 3")
                        }

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .offset(x = slide4Animation, y = yPos)
                            .background(Color(0xFF374175))){
                            Text("slide 4")
                        }

                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight()
                            .offset(x = slide5Animation, y = yPos)
                            .background(Color(0xFFFF9800))){
                            Text("slide 5")
                        }
                    }
                }

                Row(modifier = Modifier.offset(x=100.dp)){
                    Text("< previous",  modifier = Modifier.clickable {
                        menuClick--
                        menuClick = if(menuClick < 0) 0 else menuClick // never allow clicks less than 0
                        println("----------menuClick-----------> $menuClick ---> $slideState")
                        when(menuClick){
                            0 -> {
                                slideState = SlideState.SLIDE_0
                            }
                            1 -> {

                                slideState = SlideState.SLIDE_1
                            }
                            2 -> {
                                slide1Target = 400.dp
                                slideState = SlideState.SLIDE_2
                            }
                            3 -> {}
                            4 -> {}
                            5 -> {}
                        }
                    })

                    Spacer(modifier = Modifier.width(16.dp))

                    Text("next >", modifier = Modifier.clickable {
                        menuClick++
                        menuClick = if(menuClick > 2) 2 else menuClick // never allow clicks greater than total num slides-1
                        println("----------menuClick-----------> $menuClick ---> $slideState")
                        when(menuClick){
                            0 -> {
                                slideState = SlideState.SLIDE_0
                            }
                            1 -> {
                                slideState = SlideState.SLIDE_1
                            }
                            2 -> {
                                slide1Target = 400.dp
                                slideState = SlideState.SLIDE_2
                            }
                            3 -> {}
                            4 -> {}
                            5 -> {}
                        }
                    })
                }
            }
        }
    }
}

enum class SlideState {
    SLIDE_0, SLIDE_1, SLIDE_2, SLIDE_3, SLIDE_4, SLIDE_5,
}