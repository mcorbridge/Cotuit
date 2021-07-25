package com.example.cotuit.slides

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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

class Slide9 {

    companion object{

        @Composable
        fun Slide(
            slideState: SlideState,
            dataClass: MyDataClass ?= null
        ){

            var slideTarget by remember { mutableStateOf((-400).dp) }

            if(slideState == SlideState.SLIDE_8){
                slideTarget = (-400).dp
            }

            // In preparation should a new slide be added to the slide deck
            //if(slideState == SlideState.SLIDE_10){
            //    slideTarget = 400.dp
            //}


            val modifier0 = Modifier
                .offset(x=50.dp, y=50.dp).background(color = Color(0xFFCDDC39)).border(width = 2.dp, color = Color.Blue).padding(6.dp)
            val modifier1 = Modifier
                .offset(x=25.dp, y=150.dp).background(color = Color(0xFFFFEB3B)).border(width = 4.dp, color = Color.Red).padding(8.dp)
            val modifier2 = Modifier
                .offset(x=50.dp, y=200.dp).background(color = Color(0xFFEB8565)).border(width = 6.dp, color = Color.Green).padding(10.dp)
            val modifier3 = Modifier
                .offset(x=25.dp, y=250.dp).background(color = Color(0xFFDA4F24)).border(width = 6.dp, color = Color.White).padding(15.dp)
            val modifier4 = Modifier
                .offset(x=50.dp, y=300.dp).background(color = Color(0xFF00BCD4)).border(width = 6.dp, color = Color.Black).padding(20.dp)

            val modifier5 = modifier0.fillMaxSize()


            var whichModifier by remember { mutableStateOf(modifier0)}
            var ndx by remember {
                mutableStateOf(0)
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_9) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide9Animation finished") })

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = slideAnimation, y = 0.dp)
                .background(Color(0xFF03A9F4))){

                Text("Are Modifiers similar to CSS?", fontSize = 28.sp, modifier = Modifier.background(Color(0xFFE7CE81)))

                ViewColumn(whichModifier, dataClass){
                    ndx++
                    when(ndx){
                        1 -> whichModifier = modifier1
                        2 -> whichModifier = modifier2
                        3 -> whichModifier = modifier3
                        4 -> whichModifier = modifier4
                        5 -> whichModifier = modifier5
                        else -> {
                            ndx = 0
                            whichModifier = modifier0
                        }
                    }
                }

                if(ndx == 5){
                    Text("YES THEY ARE!", fontSize = 28.sp, color = Color.White, fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.offset(x=50.dp, y=450.dp))
                }


            }
        }

        @Composable
        fun ViewColumn(modifier: Modifier, dataClass: MyDataClass?, callback:() -> Unit){
            Column (modifier = modifier){
                Text("Slide #9 - dynamically loaded modifiers")
                Text("${dataClass?.name} ${dataClass?.value}")
                Button(onClick = { callback() }) {
                    Text("switch Modifier?")
                }
            }
        }
    }
}