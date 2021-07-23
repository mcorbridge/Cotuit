package com.example.cotuit.test

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cotuit.menu.NavIcon
import com.example.cotuit.slides.*

class SlideShow {

    companion object{

        @Composable
        fun DoSlideShow(navController: NavHostController) {

            var menuClick by remember { mutableStateOf(0) }
            var slideState by remember { mutableStateOf(SlideState.SLIDE_0) }
            val dataClass by remember { mutableStateOf(MyDataClass("foo","bar"))}

            fun handleMenuClick(menuClick:Int){
                when(menuClick){
                    0 -> { slideState = SlideState.SLIDE_0 }
                    1 -> { slideState = SlideState.SLIDE_1 }
                    2 -> { slideState = SlideState.SLIDE_2 }
                    3 -> { slideState = SlideState.SLIDE_3 }
                    4 -> { slideState = SlideState.SLIDE_4 }
                    5 -> { slideState = SlideState.SLIDE_5 }
                    6 -> { slideState = SlideState.SLIDE_6 }
                    7 -> { slideState = SlideState.SLIDE_7 }
                    8 -> { slideState = SlideState.SLIDE_8 }
                    9 -> { slideState = SlideState.SLIDE_9 }
                }
            }

            BoxWithConstraints(modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0778AC))) {

                Column{
                    // allow navigation back to Main Menu
                    NavIcon.MenuIcon(navController = navController)

                    BoxWithConstraints() {
                        Slide0.Slide(slideState)
                        Slide1.Slide(slideState)
                        Slide2.Slide(slideState)
                        Slide3.Slide(slideState)
                        Slide4.Slide(slideState)
                        Slide5.Slide(slideState)
                        Slide6.Slide(slideState, dataClass) // <-- passing info to slides
                        Slide7.Slide(slideState, dataClass)
                        Slide8.Slide(slideState, dataClass)
                        Slide9.Slide(slideState, dataClass)
                    }
                }

                Row(modifier = Modifier.offset(x=100.dp)){
                    Text("< previous",  modifier = Modifier.clickable {
                        menuClick--
                        menuClick = if(menuClick < 0) 0 else menuClick // never allow clicks less than 0
                        handleMenuClick(menuClick)
                    })

                    Spacer(modifier = Modifier.width(16.dp))

                    Text("next >", modifier = Modifier.clickable {
                        menuClick++
                        menuClick = if(menuClick > 9) 9 else menuClick // never allow clicks greater than total num slides-1
                        handleMenuClick(menuClick)
                    })
                }
            }


        }
    }
}

enum class SlideState {
    SLIDE_0, SLIDE_1, SLIDE_2, SLIDE_3, SLIDE_4, SLIDE_5, SLIDE_6, SLIDE_7, SLIDE_8, SLIDE_9,
}

data class MyDataClass(var name:String, var value:String)



