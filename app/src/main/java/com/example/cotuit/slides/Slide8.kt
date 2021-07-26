package com.example.cotuit.slides

import android.icu.number.Notation.simple
import android.os.Build
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState
import com.example.cotuit.util.RandNames
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*

class Slide8 {

    companion object{

        private val rndTimes = listOf<Long>(1000, 5000, 100, 1500, 2700, 750, 258, 612, 1212, 430, 2000)
        //private val rndTimes = listOf<Long>(10, 50, 10, 15, 27, 75, 25, 61, 12, 430, 20)

        @Composable
        fun Slide(
            slideState: SlideState,
            dataClass: MyDataClass ?= null
        ){

            var slideTarget by remember { mutableStateOf((-400).dp) }
            var currentName by remember { mutableStateOf("tbd") }
            var kounter by remember {mutableStateOf(0)}
            var coroutineScope = rememberCoroutineScope()


            val foo: (String) -> Unit = {
                println("** i am foo ** $it")
                currentName = it
            }

            var bar by remember {
                mutableStateOf(foo)
            }


            if(slideState == SlideState.SLIDE_7){
                slideTarget = (-400).dp
            }
            if(slideState == SlideState.SLIDE_9){
                slideTarget = 400.dp
            }

            val namesFlow = flow {
                val names = RandNames.nameGetter()
                for (name in names) {
                    val rnd = rndTimes[(0..10).random()]
                    delay(rnd)
                    emit(name)
                }
            }

            /**
             * runBlocking is a low-level construct, to be used ONLY in framework code or self-contained
             * examples. It turns an existing thread into an event loop and creates its
             * coroutine with a Dispatcher that posts resuming coroutines to the event loop's queue.
             * (whatever the fuck THAT means)
             */

            fun mainFlow() = runBlocking {
                namesFlow.collect {
                    kounter++
                    currentName = it
                    println("$kounter $it $currentName")
                }
            }

            /**
             * coroutineScope is a user-facing construct, used to delineate the boundaries of a task
             * that is being parallel-decomposed inside it. You use it to conveniently await on all the
             * async work happening inside it, get the final result, and handle all failures at one central place.
             */

            fun mainFlowZ() = coroutineScope.launch() {
                namesFlow.collect {
                    kounter++
                    currentName = it
                    println("$kounter $it $currentName")
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

                    Text("Slide #8 - Kotlin Flow")
                    Text("${dataClass?.name} ${dataClass?.value}")

                    //onClick is not composable. It's a regular function.!!!!
                    Button(onClick = {
                        mainFlowZ()
                    }) {
                        Text("Go -> Flow")
                    }

                    Text("currentName = $currentName")

                    Text("What about the onClick lambda?", fontWeight = FontWeight.ExtraBold)

                     Text("Recompose scopes are only created around composable functions. Event " +
                             "handlers, like Button's onClick, are not composable, they're just regular " +
                             "functions. When the click handler is invoked by the framework, it is " +
                             "done so outside of any recompose scope.")

                    Text("explain runBlocking...", fontWeight = FontWeight.ExtraBold)

                    Text("runBlocking is a low-level construct, to be used ONLY in framework code or self-contained " +
                            "examples. It turns an existing thread into an event loop and creates its " +
                            "coroutine with a Dispatcher that posts resuming coroutines to the event loop's queue. " +
                            "(whatever the fuck THAT means)")

                    Text("... versus coroutineScope", fontWeight = FontWeight.ExtraBold)

                    Text("coroutineScope is a user-facing construct, used to delineate the boundaries of a task " +
                            "that is being parallel-decomposed inside it. You use it to conveniently await on all the " +
                            "async work happening inside it, get the final result, and handle all failures at one central place.")

                    Column()
                    {
                        Text("kounter is: " + kounter)
                        Button(onClick = { kounter++ }) {
                            Text("kounter up")
                        }
                    }

                }

            }


        }





    } //end companion object
} // end class

