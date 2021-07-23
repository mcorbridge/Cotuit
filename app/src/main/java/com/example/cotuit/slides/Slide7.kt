package com.example.cotuit.slides

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState
import kotlinx.coroutines.launch

class Slide7 {

    companion object{

        @Composable
        fun Slide(
            slideState: SlideState,
            dataClass: MyDataClass ?= null
        ){

            var slideTarget by remember { mutableStateOf((-400).dp) }
            val state = rememberScaffoldState()
            val coroutineScope = rememberCoroutineScope()


            if(slideState == SlideState.SLIDE_6){
                slideTarget = (-400).dp
            }
            if(slideState == SlideState.SLIDE_8){
                slideTarget = 400.dp
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_7) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide7Animation finished") })

            Scaffold(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .offset(x = slideAnimation, y = 0.dp)
                    .background(Color(0xFF03A9F4)),
                scaffoldState = state,
                topBar = {
                    TopAppBar(
                        title = { Text(text = "Slide #7") },
                        navigationIcon = {

                            Icon(Icons.Default.Menu, contentDescription = "Localized description",
                                modifier = Modifier.clickable(onClick = {
                                   println("state.drawerState.isOpen? ${state.drawerState.isOpen}")
                                    coroutineScope.launch { state.drawerState.open() }
                                }))
                        }
                    )
                },
                drawerShape = MaterialTheme.shapes.large,
                drawerElevation = 16.dp,
                drawerContent = {
                    Text(text = "Drawer")
                }
            ) {
                // Scaffold body
            }
        }

        @Composable
        fun ScaffoldContent(callback:() -> Unit){
            Column{
                Text("content")
                Text("Scaffold Example", fontSize = 76.sp)
                Button(onClick = { callback()}) {

                }
            }
        }

    } // end companion object

} // end class

