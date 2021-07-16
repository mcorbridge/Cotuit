package com.example.cotuit.test

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cotuit.menu.NavIcon

class DegreesOfAnimation {


    companion object {


        @Composable
        fun SwitchingSquares(navController: NavHostController) {

            var isButton by remember { mutableStateOf(true) }
            var isClicked by remember { mutableStateOf(false) }
            var counter by remember { mutableStateOf(0) }

            // top left
            var whiteX by remember { mutableStateOf(0.dp) }
            var whiteY by remember { mutableStateOf(0.dp) }

            // top left
            var yellowX by remember { mutableStateOf(293.dp) }
            var yellowY by remember { mutableStateOf(653.dp) }

            // bottom left
            var blueX by remember { mutableStateOf(0.dp) }
            var blueY by remember { mutableStateOf(653.dp) }

            // bottom left
            var redX by remember { mutableStateOf(293.dp) }
            var redY by remember { mutableStateOf(0.dp) }

            // top middle
            var greenX by remember { mutableStateOf(293.dp / 2) }
            var greenY by remember { mutableStateOf(0.dp) }

            // bottom middle
            var cyanX by remember { mutableStateOf(293.dp / 2) }
            var cyanY by remember { mutableStateOf(653.dp) }

            // left middle
            var magnetaX by remember { mutableStateOf(0.dp) }
            var magnetaY by remember { mutableStateOf(653.dp / 2) }

            // right middle
            var grayX by remember { mutableStateOf(293.dp) }
            var grayY by remember { mutableStateOf(653.dp / 2) }

            val whiteMoverX: Dp by animateDpAsState(
                targetValue = whiteX,
                animationSpec = tween(3000),
                finishedListener = {
                    counter++
                    isButton = true
                }
            )

            val whiteMoverY: Dp by animateDpAsState(
                targetValue = whiteY,
                animationSpec = tween(3000)
            )

            val yellowMoverX: Dp by animateDpAsState(
                targetValue = yellowX,
                animationSpec = tween(3000)
            )

            val yellowMoverY: Dp by animateDpAsState(
                targetValue = yellowY,
                animationSpec = tween(3000),
            )

            val blueMoverX: Dp by animateDpAsState(
                targetValue = blueX,
                animationSpec = tween(3000)
            )

            val blueMoverY: Dp by animateDpAsState(
                targetValue = blueY,
                animationSpec = tween(3000),
            )

            val redMoverX: Dp by animateDpAsState(
                targetValue = redX,
                animationSpec = tween(3000)
            )

            val redMoverY: Dp by animateDpAsState(
                targetValue = redY,
                animationSpec = tween(3000),
            )

            val greenMoverX: Dp by animateDpAsState(
                targetValue = greenX,
                animationSpec = tween(3000)
            )

            val greenMoverY: Dp by animateDpAsState(
                targetValue = greenY,
                animationSpec = tween(3000),
            )

            val cyanMoverX: Dp by animateDpAsState(
                targetValue = cyanX,
                animationSpec = tween(3000)
            )

            val cyanMoverY: Dp by animateDpAsState(
                targetValue = cyanY,
                animationSpec = tween(3000),
            )

            val magnetaMoverX: Dp by animateDpAsState(
                targetValue = magnetaX,
                animationSpec = tween(3000)
            )

            val magnetaMoverY: Dp by animateDpAsState(
                targetValue = magnetaY,
                animationSpec = tween(3000),
            )

            val grayMoverX: Dp by animateDpAsState(
                targetValue = grayX,
                animationSpec = tween(3000)
            )

            val grayMoverY: Dp by animateDpAsState(
                targetValue = grayY,
                animationSpec = tween(3000),
            )

            Box(modifier = Modifier.fillMaxSize()) {

                Box(
                    modifier = Modifier
                        .offset(x = whiteMoverX, y = whiteMoverY)
                        .height(100.dp)
                        .width(100.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(color = Color.White)
                ) {

                    if (isButton) {
                        Button(onClick = {
                            isClicked = !isClicked
                            isButton = false

                            if (isClicked) {
                                whiteX = 293.dp
                                whiteY = 653.dp

                                yellowX = 0.dp
                                yellowY = 0.dp

                                blueX = 293.dp
                                blueY = 0.dp

                                redX = 0.dp
                                redY = 653.dp

                                greenX = 293.dp / 2
                                greenY = 653.dp

                                cyanX = 293.dp / 2
                                cyanY = 0.dp

                                magnetaX = 293.dp
                                magnetaY = 653.dp / 2

                                grayX = 0.dp
                                grayY = 653.dp / 2
                            } else {
                                whiteX = 0.dp
                                whiteY = 0.dp

                                yellowX = 293.dp
                                yellowY = 653.dp

                                blueX = 0.dp
                                blueY = 653.dp

                                redX = 293.dp
                                redY = 0.dp

                                greenX = 293.dp / 2
                                greenY = 0.dp

                                cyanX = 293.dp / 2
                                cyanY = 653.dp

                                magnetaX = 0.dp
                                magnetaY = 653.dp / 2

                                grayX = 293.dp
                                grayY = 653.dp / 2
                            }

                        }) {
                            Text("start")
                        }
                    }

                }

                Box(
                    modifier = Modifier
                        .offset(x = blueMoverX, y = blueMoverY)
                        .height(100.dp)
                        .width(100.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(color = Color.Blue)
                )

                Box(
                    modifier = Modifier
                        .offset(x = 293.dp / 2, y = 653.dp / 2)
                        .height(100.dp)
                        .width(100.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(color = Color.LightGray)
                ) {
                    Text(
                        "$counter",
                        fontSize = 32.sp,
                        color = Color.White,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Box(
                    modifier = Modifier
                        .offset(x = redMoverX, y = redMoverY)
                        .height(100.dp)
                        .width(100.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(color = Color.Red)
                )

                Box(
                    modifier = Modifier
                        .offset(x = yellowMoverX, y = yellowMoverY)
                        .height(100.dp)
                        .width(100.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(color = Color.Yellow)
                )

                Box(
                    modifier = Modifier
                        .offset(x = greenMoverX, y = greenMoverY)
                        .height(100.dp)
                        .width(100.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(color = Color.Green)
                )

                Box(
                    modifier = Modifier
                        .offset(x = cyanMoverX, y = cyanMoverY)
                        .height(100.dp)
                        .width(100.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(color = Color.Cyan)
                )

                Box(
                    modifier = Modifier
                        .offset(x = magnetaMoverX, y = magnetaMoverY)
                        .height(100.dp)
                        .width(100.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(color = Color.Magenta)
                )

                Box(
                    modifier = Modifier
                        .offset(x = grayMoverX, y = grayMoverY)
                        .height(100.dp)
                        .width(100.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(color = Color.Gray)
                )

                Box(
                    modifier = Modifier
                        .offset(x = grayMoverX, y = grayMoverY)
                        .height(100.dp)
                        .width(100.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(color = Color.Gray)
                )
            }

            // allow navigation back to Main Menu
            NavIcon.MenuIcon(navController = navController)

        }
    }
}




