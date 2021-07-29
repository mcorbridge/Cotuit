package com.example.cotuit.test

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cotuit.menu.NavIcon
import com.example.cotuit.menu.Routes
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class TestWally{

    val myEasing = CubicBezierEasing(0f, 0f, 0f, 0f)
    val myEazing = CubicBezierEasing(1f, -1f, 1f, -1f)

    val myAnimSpec: AnimationSpec<Dp> = repeatable(
        iterations = 5,
        animation = tween(1000, 10, myEasing),
        repeatMode = RepeatMode.Reverse)

    val myAnimZpec: AnimationSpec<Dp> = repeatable(
        iterations = 5,
        animation = tween(1000, 10, myEazing),
        repeatMode = RepeatMode.Restart)

    @Composable
    fun RotatingSquareComponent(navController:NavHostController) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .border(width = 1.dp, color = Color.LightGray)
        ) {

            //MyMovingSquare()

            //MyRotatingSquare()

            //TestingAnimatable()

            //TestingCoroutineScope()

            //AnimatingTheComposeGalaxy.ThirdThing()

            //DegreesOfAnimation.One()

            DegreesOfAnimation.SwitchingSquares(navController)
        }

    }

    @Composable
    fun TestingCoroutineScope(){
        var testCoroutine = TestCoroutine()
        testCoroutine.DoTestCoroutine()
    }

    @Composable
    fun MyMovingSquare(navController: NavHostController) {

        var boxState by remember { mutableStateOf(BoxPosition.START) }

        var isHeightCollapsed by remember { mutableStateOf(false)}

        val animSpec: AnimationSpec<Dp> = repeatable(
            iterations = 5,
            animation = tween(1000, 10, myEasing),
            repeatMode = RepeatMode.Reverse
        )

        val animZpec: AnimationSpec<Dp> = repeatable(
            iterations = 5,
            animation = tween(1000, 500, myEasing),
            repeatMode = RepeatMode.Reverse
        )

        /**
         * Note, animateDpAsState cannot be canceled/stopped without removing this composable
         * function from the tree. See Animatable for cancelable animations.
         */
        val offsetAnimation: Dp by animateDpAsState(
            targetValue = if (boxState == BoxPosition.START) 0.dp else 340.dp ,
            animationSpec = animSpec) {
            isHeightCollapsed = true // <- finishedListener
        }

        val zoffsetAnimation: Dp by animateDpAsState(
            targetValue = if (boxState == BoxPosition.START) 0.dp else 340.dp ,
            animationSpec = animZpec)

        Column(

            content = {

                    Canvas(
                        modifier = Modifier
                            .size(50.dp)
                            .offset(x = offsetAnimation)
                    ) {
                        drawRect(color = Color.Blue)
                    }


                    Canvas(
                        modifier = Modifier
                            .size(50.dp)
                            .offset(x = zoffsetAnimation)
                    ) {
                        drawRect(color = Color.Red)
                    }

                // silly shit
                HeightAnimation(isHeightCollapsed, Color.LightGray, 100.dp, 5.dp, myAnimSpec)
                HeightAnimation(isHeightCollapsed, Color.DarkGray, 200.dp, 10.dp, myAnimSpec)
                HeightAnimation(isHeightCollapsed, Color.Yellow, 300.dp, 15.dp, myAnimSpec)
                HeightAnimation(isHeightCollapsed, Color.Black, 400.dp, 20.dp, myAnimSpec)

                // allow navigation back to Main Menu
                NavIcon.MenuIcon(navController = navController)

            }
        )

        /**
         * here we launch the Repeatable animation dynamically (no onClick event required)
         */
        val coroutineScope = rememberCoroutineScope()
        var isCoroutineRun by remember { mutableStateOf(false) }

        val getFoo: () -> Unit = {
            coroutineScope.launch {
                isCoroutineRun = true
                delay(10)
                boxState = BoxPosition.FINISH
            }
        }

        if (!isCoroutineRun) {
            getFoo()
        }

    }

    @Composable
    fun MenuIcon(navController: NavHostController) {
        Box {
            Icon(Icons.Rounded.Menu, contentDescription = "Localized description",modifier = Modifier.clickable {
                navController.navigate(Routes.MENU.route)
            })
        }
    }

    @Composable
    fun HeightAnimation(collapsed: Boolean, bgColor:Color, initialHeight:Dp, finalHeight:Dp, animationSpec:AnimationSpec<Dp>) {
        // Animates a height of [Dp] type to different target values based on the [collapsed] arg.
        val height: Dp by animateDpAsState(
            targetValue = if (collapsed) finalHeight else initialHeight,
            animationSpec = animationSpec,
            finishedListener = {
                println("I am finished!! $it")
            }

        )

        Box(
            Modifier
                .fillMaxWidth()
                .requiredHeight(height)
                .background(color = bgColor))
    }



    @Composable
    fun MyRotatingSquare(navController: NavHostController) {
        val infiniteTransition = rememberInfiniteTransition()

        var ndx by remember { mutableStateOf(0) }

        var isIncremented by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            content = {

                val rotation by infiniteTransition.animateFloat(
                    initialValue = 0f,
                    targetValue = 360f,
                    animationSpec = infiniteRepeatable(
                        animation = tween<Float>(
                            durationMillis = 3000,
                            easing = myEasing,
                        ),
                    )
                )

                // this counter prevents 'over-incrementing' the counter by preventing incrementing
                // twice inside the 355..360 range, yet allowing the counter to catch the float value
                // as it passes through the range (maybe I didn't explain that properly, but it works)
                if (rotation in 355f..360f && !isIncremented) {
                    isIncremented = true
                    ndx++
                }
                if(rotation in 0f..60f){ // we are now safely outside the range, so reset isIncremented
                    isIncremented = false
                }


                Canvas(modifier = Modifier.size(200.dp)) {
                    rotate(rotation) {
                        drawRect(color = Color(255, 138, 128))
                        val paint = android.graphics.Paint()
                        paint.textSize = 164f
                        paint.color = 0xff000000.toInt()
                        drawIntoCanvas {
                            it.nativeCanvas.drawText("$ndx", center.x, center.y, paint)
                        }
                    }
                }

                // allow navigation back to Main Menu
                NavIcon.MenuIcon(navController = navController)
            })

    }

    @Composable
    fun TestingAnimatable(){
        var testAnimatable = TestAnimatable()
        testAnimatable.DoAnimatable()
    }


} // end class

enum class BoxPosition {
    START, FINISH
}

