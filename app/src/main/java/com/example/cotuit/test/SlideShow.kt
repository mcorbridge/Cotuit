package com.example.cotuit.test

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cotuit.menu.NavIcon
import com.example.cotuit.slides.*

class SlideShow {

    companion object{

        @Composable
        fun DoSlideShow(navController: NavHostController) {


            var menuClick by remember { mutableStateOf(0) }
            var currentSlide by remember { mutableStateOf(0) }
            var direction by remember { mutableStateOf("NEXT")}

            var slideState by remember { mutableStateOf(SlideState.SLIDE_0) }
            val slide0Target by remember { mutableStateOf((400).dp) }
            var slide1Target by remember { mutableStateOf((-400).dp) }
            var slide2Target by remember { mutableStateOf((-400).dp) }
            var slide3Target by remember { mutableStateOf((-400).dp) }
            var slide4Target by remember { mutableStateOf((-400).dp) }
            var slide5Target by remember { mutableStateOf((-400).dp) }
            var slide6Target by remember { mutableStateOf((-400).dp) }

            var dataClass by remember { mutableStateOf(MyDataClass("f","b"))}

            var title by remember { mutableStateOf("Slide #6") }

            BoxWithConstraints(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0778AC))) {

                Column{
                    // allow navigation back to Main Menu
                    NavIcon.MenuIcon(navController = navController)

                    BoxWithConstraints() {
                        Slide0.Slide(slideState, slide0Target, currentSlide, direction)
                        Slide1.Slide(slideState, slide1Target, currentSlide, direction)
                        Slide2.Slide(slideState, slide2Target, currentSlide, direction)
                        Slide3.Slide(slideState, slide3Target, currentSlide, direction)
                        Slide4.Slide(slideState, slide4Target, currentSlide, direction)
                        Slide5.Slide(slideState, slide5Target, currentSlide, direction)
                        Slide6.Slide(slideState, slide6Target, currentSlide, direction, title, dataClass)
                    }
                }

                Row(modifier = Modifier.offset(x=100.dp)){
                    Text("< previous",  modifier = Modifier.clickable {
                        menuClick--
                        direction = "PREVIOUS"
                        menuClick = if(menuClick < 0) 0 else menuClick // never allow clicks less than 0
                        when(menuClick){
                            0 -> {
                                currentSlide = 0
                                slide1Target = (-400).dp
                                slideState = SlideState.SLIDE_0
                            }
                            1 -> {
                                currentSlide = 1
                                slide2Target = (-400).dp
                                slideState = SlideState.SLIDE_1
                            }
                            2 -> {
                                currentSlide = 2
                                slide3Target = (-400).dp
                                slideState = SlideState.SLIDE_2
                            }
                            3 -> {
                                currentSlide = 3
                                slide4Target = (-400).dp
                                slideState = SlideState.SLIDE_3
                            }
                            4 -> {
                                currentSlide = 4
                                slide5Target = (-400).dp
                                slideState = SlideState.SLIDE_4
                            }
                            5 -> {
                                currentSlide = 5
                                slide6Target = (-400).dp
                                slideState = SlideState.SLIDE_5
                            }
                            6 -> {
                                currentSlide = 6
                                slideState = SlideState.SLIDE_6
                            }
                        }
                    })

                    Spacer(modifier = Modifier.width(16.dp))

                    Text("next >", modifier = Modifier.clickable {
                        menuClick++
                        menuClick = if(menuClick > 6) 6 else menuClick // never allow clicks greater than total num slides-1
                        direction = "NEXT"
                        when(menuClick){
                            0 -> {
                                currentSlide = 0
                                slideState = SlideState.SLIDE_0
                            }
                            1 -> {
                                currentSlide = 1
                                slideState = SlideState.SLIDE_1
                            }
                            2 -> {
                                currentSlide = 2
                                slide1Target = 400.dp
                                slideState = SlideState.SLIDE_2
                            }
                            3 -> {
                                currentSlide = 3
                                slide2Target = 400.dp
                                slideState = SlideState.SLIDE_3
                            }
                            4 -> {
                                currentSlide = 4
                                slide3Target = 400.dp
                                slideState = SlideState.SLIDE_4
                            }
                            5 -> {
                                currentSlide = 5
                                slide4Target = 400.dp
                                slideState = SlideState.SLIDE_5
                            }
                            6 -> {
                                currentSlide = 6
                                slide5Target = 400.dp
                                slideState = SlideState.SLIDE_6
                            }
                        }
                    })
                }
            }
        }
    }
}

enum class SlideState {
    SLIDE_0, SLIDE_1, SLIDE_2, SLIDE_3, SLIDE_4, SLIDE_5, SLIDE_6,
}

data class MyDataClass(var name:String, var value:String)



