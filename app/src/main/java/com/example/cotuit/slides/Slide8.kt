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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState
import com.example.cotuit.util.RandNames
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class Slide8 {

    companion object{

        private val rndTimes = listOf<Long>(1000, 5000, 100, 1500, 2700, 750, 258, 612, 1212, 430, 2000, 1964, 10, 4200, 2400, 433)

        private val rndColors = listOf(
            Color(0xFF03A9F4),
            Color(0xFFFF5722),
            Color(0xFFE91E63),
            Color(0xFFFFEB3B),
            Color(0xFF009688),
            Color(0xFF033FF4),
            Color(0xFFA36171),
            Color(0xFFC93304),
            Color(0x3B03A9F4),
            Color(0xFF849108),
            Color(0x9EFCBE06),
        )

        @Composable
        fun Slide(
            slideState: SlideState,
            dataClass: MyDataClass ?= null
        ){
            var slideTarget by remember { mutableStateOf((-400).dp) }
            var currentName by remember { mutableStateOf("tbd") }
            var kounter by remember {mutableStateOf(0)}
            val coroutineScope = rememberCoroutineScope()
            var emitTime by remember { mutableStateOf(0L)}
            var newColor by remember { mutableStateOf(Color(0xFF849108))}

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

            /**
             * Simulates a service that is randomly emitting a string over between a period of 258ms .. 5000ms
             */
            val namesFlow = flow {
                val names = RandNames.nameGetter()
                for (name in names) {
                    val rnd = rndTimes[(rndTimes.indices).random()]
                    emitTime = rnd
                    delay(rnd)
                    emit(name)
                    newColor = rndColors[(rndColors.indices).random()]
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
                }
            }

            /**
             * coroutineScope is a user-facing construct, used to delineate the boundaries of a task
             * that is being parallel-decomposed inside it. You use it to conveniently await on all the
             * async work happening inside it, get the final result, and handle all failures at one central place.
             */

            fun mainFlowZ() = coroutineScope.launch {
                namesFlow.collect {
                    kounter++
                    currentName = it
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

                    Spacer(modifier=Modifier.height(16.dp))

                    Text("name = $currentName\nemit wait = $emitTime ms",
                        fontWeight = FontWeight.ExtraBold, color = newColor,
                        fontSize = 32.sp,
                        modifier = Modifier.background(color = Color.White).fillMaxWidth())

                    Spacer(modifier=Modifier.height(16.dp))

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
                        Text("kounter is: $kounter")
                        Button(onClick = { kounter++ }) {
                            Text("kounter up")
                        }
                    }

                }

            }


        }





    } //end companion object
} // end class

