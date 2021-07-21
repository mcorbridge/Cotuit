package com.example.cotuit.slides

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cotuit.kotlinIdioms.PlayingWithKotlinIdioms
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState

class Slide1 {


    init{
        println("::Slide1.init")
    }

    companion object{

        var foo = ""

        init{

            val lazyValue: String by lazy {
                println("lazy val computed!")
                "I am Lazy!"
            }

            foo = lazyValue
            println("INIT $lazyValue")
        }

        @Composable
        fun Slide(slideState: SlideState, dataClass: MyDataClass?= null){

            var slideTarget by remember { mutableStateOf((-400).dp) }

            var whatIsLazy by remember {
                mutableStateOf("")
            }

            // read this as NOT! where SLIDE_0 or SLIDE_2 goes, but where SLIDE_1 goes
            // when '<previous' or 'next>' is pressed when SLIDE_1 is currently visible
            if(slideState == SlideState.SLIDE_0){
                slideTarget = (-400).dp
            }
            if(slideState == SlideState.SLIDE_2){
                slideTarget = 400.dp
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

                Column{
                    Text("Slide #1 ")
                    Text("Testing Kotlin Lazy Delegate ")
                    Text("lazy() is a function that takes a lambda and returns an instance of Lazy<T> which \n" +
                            "can serve as a delegate for implementing a lazy property: the first call to get() \n" +
                            "executes the lambda passed to lazy() and remembers the result, subsequent calls to \n" +
                            "get() simply return the remembered result.")
                    Text(" Who is lazy? >>>>>> $whatIsLazy")
                    Button(onClick = {
                        whatIsLazy = foo
                    }) {
                        Text("get lazy value")
                    }
                    Text("To be perfectly honest, I don't fully understand a practical implementation of this " +
                            "Delegate, but that's probably because I don't write code that runs into memory problems " +
                            "(yet), and / or I'm too stupid to understand it. ")
                }




            }
        }

        @Composable
        fun DoTest(function: () -> Unit) {
            PlayingWithKotlinIdioms.DoPlay()
            function()
        }
    }
}