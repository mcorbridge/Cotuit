package com.example.cotuit.slides

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState

class Slide5 {

    companion object{

        @Composable
        fun Slide(slideState: SlideState, dataClass: MyDataClass?= null){

            var slideTarget by remember { mutableStateOf((-400).dp) }

            if(slideState == SlideState.SLIDE_4){
                slideTarget = (-400).dp
            }
            if(slideState == SlideState.SLIDE_6){
                slideTarget = 400.dp
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_5) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide5Animation finished") })

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = slideAnimation, y = 0.dp)
                .background(Color(0xFF03A9F4))){

                Column{

                    Text("Slide #5 - Responsive layouts", fontWeight = FontWeight.ExtraBold)

                    Text("In order to know the constraints coming from the parent and design " +
                            "the layout accordingly, you can use a BoxWithConstraints. The measurement " +
                            "constraints can be found in the scope of the content lambda. You can " +
                            "use these measurement constraints to compose different layouts for " +
                            "different screen configurations:")

                    BoxWithConstraints(modifier = Modifier.border(width = 2.dp, color = Color.Blue)) {
                            Text("this is a 'BoxWithConstraints'\n" +
                                    "My minHeight is $minHeight\n" +
                                    "My maxHeight is $maxHeight\n" +
                                    "while my minWidth is $minWidth\n" +
                                    "and my maxWidth is $maxWidth")
                    }

                }


            }
        }
    }
}