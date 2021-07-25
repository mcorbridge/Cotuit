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

        @RequiresApi(Build.VERSION_CODES.R)
        @Composable
        fun Slide(
            slideState: SlideState,
            dataClass: MyDataClass ?= null
        ){

            var slideTarget by remember { mutableStateOf((-400).dp) }
            var currentName by remember { mutableStateOf("tbd") }
            var names = mutableListOf<String>()

            if(slideState == SlideState.SLIDE_7){
                slideTarget = (-400).dp
            }
            if(slideState == SlideState.SLIDE_9){
                slideTarget = 400.dp
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

                    Button(onClick = {
                        //processValues()
                        //mainFlow2(names)
                        mainFlowZ(names){
                            println("currentName = $it")
                            currentName = it
                        }
                    }) {
                        Text("Go -> Flow")
                    }

                    Button(onClick = {
                        //processValues()
                        names = RandNames.nameGetter()
                        currentName = "Names -> Get"
                    }) {
                        Text("Names -> Get")
                    }

                    Text("currentName = $currentName")
                }

            }
        }



//        suspend fun getValues(): List<Int> {
//            delay(1000)
//            return listOf(1, 2, 3)
//        }

        fun processValues() {
            runBlocking {
                val values = getValues()
                for (value in values) {
                    println(value)
                }
            }
        }

        suspend fun getValues(): Sequence<Int> = sequence {
            Thread.sleep(250)
            yield(1)
            Thread.sleep(250)
            yield(2)
            Thread.sleep(250)
            yield(3)
        }

        val namesFlow = flow {
            val names = listOf("Jody", "Steve", "Lance", "Joe")
            for (name in names) {
                delay(1000)
                emit(name)
            }
        }

        val namesFlowToo = flowOf("Jody", "Steve", "Lance", "Joe")

        fun mainFlow() = runBlocking {
            namesFlow
                .map { name -> name.length }
                .filter { length -> length < 5 }
                .collect { println(it) }

            println("--------------- finished --------------")
        }

        fun mainFlow2(names:MutableList<String>) = runBlocking {
            //val namesFloz = flowOf(names)
            val namesFloz = flowOf("Jody", "Steve", "Lance", "Joe")

            namesFloz
                .map { name -> name.uppercase(Locale.getDefault()) }
                .filter { name -> name.length < 15 }
                .collect { println(it) }

            println("--------------- finished --------------")
        }

        @RequiresApi(Build.VERSION_CODES.R)
        fun mainFlowZ(names:MutableList<String>, callback:(String) -> Unit) = runBlocking<Unit> {
            // Launch a concurrent coroutine to check if the main thread is blocked
            launch {
                names.forEach { name ->
                    println("current name from list =  $name")
                    callback(name)
                    delay(1000)
                }
            }
        }




    } //end companion object
} // end class

