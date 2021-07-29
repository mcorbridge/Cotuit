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
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState
import kotlin.properties.Delegates

class Slide2 {

    companion object{

        @Composable
        fun Slide(slideState: SlideState, dataClass: MyDataClass?= null){

            var slideTarget by remember { mutableStateOf((-400).dp) }
            var kounter by remember { mutableStateOf(0) }

            if(slideState == SlideState.SLIDE_1){
                slideTarget = (-400).dp
            }
            if(slideState == SlideState.SLIDE_3){
                slideTarget = 400.dp
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_2) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide2Animation finished") })

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = slideAnimation, y = 0.dp)
                .background(Color(0xFF03A9F4))){
                Column{
                    Text("Slide #2 - Observable properties")
                    Text("Delegates.observable() takes two arguments: the initial value and a handler for modifications.\n" +
                            "The handler is called every time you assign to the property (after the assignment has been performed). " +
                            "It has three parameters: a property being assigned to, the old value and the new one:")

                    Button(onClick = {
                        if(kounter == 0){
                            main("Wally", "Walking", "TheWalk")

                        }else{
                            main("Wally", "Foxwoods", "Kibble-Muncher")
                        }
                        kounter++
                    }) {
                        Text("Observable")
                    }

                }

            }
        }

        private val user = User {
            println(it)
        }

        fun main(firstName:String, middleName:String, lastName:String) {
            user.fname = firstName
            user.mname = middleName
            user.lname = lastName
        }
    }
}

class User(callback:(String) -> Unit) {
    var fname: String by Delegates.observable("<no name>") {
            prop, old, new ->
        callback("$old -> $new")
    }
    var mname: String by Delegates.observable("<no name>") {
            prop, old, new ->
        callback("$old -> $new")
    }
    var lname: String by Delegates.observable("<no name>") {
            prop, old, new ->
        callback("$old -> $new")
    }
}