package com.example.cotuit.test

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class TestCoroutine {

    @Composable
    fun DoTestCoroutine() {

        var isTrue by remember { mutableStateOf(-1) }

        DoTest(){
            isTrue = it // <- the ESSENCE of Compose! Each time 'isTrue' is modified (set) DoTestCoroutine() runs
        }

        Box(modifier = Modifier.background(color = Color(0x74D5A45D), shape = CircleShape).border(2.dp,color = Color.Black)){
            when(isTrue){
                0 -> Text("Now is the winter of our discontent", modifier = Modifier.padding(100.dp))
                1 -> Text("Made glorious summer by this sun of York;", modifier = Modifier.padding(100.dp))
                2 -> Text("And all the clouds that lour'd upon our house", modifier = Modifier.padding(100.dp))
                3 -> Text("In the deep bosom of the ocean buried.", modifier = Modifier.padding(100.dp))
                4 -> Text("Now are our brows bound with victorious wreaths;", modifier = Modifier.padding(100.dp))
                5 -> Text("Our bruised arms hung up for monuments;", modifier = Modifier.padding(100.dp))
                else -> Text("...................",modifier = Modifier.padding(100.dp))
            }
        }


    }


    @Composable
    fun DoTest(callback: (Int) -> Unit) {

        val coroutineScope = rememberCoroutineScope()
        //var n by remember { mutableStateOf(0) } // triggers recomposition, and a real mess
        var n = 0 // does NOT trigger recomposition

        val getOne: () -> Unit = {
            coroutineScope.launch {
                delay(1 * 1001)
                println("1s hello")
                callback(0)
            }
            n++ // <- just to prove the point
        }

        val getTwo: () -> Unit = {
            coroutineScope.launch {
                delay(4 * 1002)
                callback(1)
            }
            n++ // <- just to prove the point
        }

        val getThree: () -> Unit = {
            coroutineScope.launch {
                delay(7 * 1003)
                callback(2)
            }
            n++ // <- just to prove the point
        }

        val getFour: () -> Unit = {

            coroutineScope.launch {
                delay(10 * 1200)
                callback(3)
            }

            coroutineScope.launch {
                delay(13 * 1300)
                callback(4)
            }

            coroutineScope.launch {
                delay(18 * 1400)
                callback(5)
            }
            n++ // <- just to prove the point
        }


        getOne()
        getTwo()
        getThree()
        getFour()


    } //


} //end class