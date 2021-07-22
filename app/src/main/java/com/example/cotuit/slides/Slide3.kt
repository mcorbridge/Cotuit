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
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState

class Slide3 {

    companion object{

        @Composable
        fun Slide(slideState: SlideState, dataClass: MyDataClass?= null){

            var slideTarget by remember { mutableStateOf((-400).dp) }

            var kounter by remember { mutableStateOf(0) }

            var klass by remember { mutableStateOf(MyClass()) }



            if(slideState == SlideState.SLIDE_2){
                slideTarget = (-400).dp
            }
            if(slideState == SlideState.SLIDE_4){
                slideTarget = 400.dp
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_3) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide3Animation finished") })

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = slideAnimation, y = 0.dp)
                .background(Color(0xFF03A9F4))){

                Column{
                    Text("Slide #3 - Delegating to another property")

                    Text("A property can delegate its getter and setter to another property. " +
                            "Such delegation is available for both top-level and class properties " +
                            "(member and extension).")

                    if(kounter != 0){
                        Text("delegating oldValue to newValue: ${klass.newValue}", fontWeight = FontWeight.ExtraBold)
                    }else{
                        Text("delegating oldValue to newValue: ${klass.newValue}")
                    }


                    Button(onClick = {
                        if(kounter == 0){
                            doDelegation(klass, 42)
                        }
                        kounter++
                    }) {
                        Text("delegate to another property")
                    }

                    Text("What is the purpose of this?\n\n" +
                            "This may be useful, for example, when you want to rename a property " +
                            "in a backward-compatible way: you introduce a new property, annotate " +
                            "the old one with the @Deprecated annotation, and delegate its implementation.\n\n" +
                            "Oooooooookay ...... I guess that makes sense")
                }



            }
        }

        fun doDelegation(klass:MyClass, newValue:Int){
            // Notification: 'oldName: Int' is deprecated.
            // Use 'newName' instead
            klass.oldValue = newValue
        }
    }
}

class MyClass {
    var newValue: Int = 0
    @Deprecated("Use 'newName' instead", ReplaceWith("newName"))
    var oldValue: Int by this::newValue
}