package com.example.cotuit.test

import android.graphics.Paint
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cotuit.menu.NavIcon


/**
 * Without a doubt one of the more complex things I have ever done in Jetpack Compose / Kotlin
 * it looks simple, but it's hard... friggin' hard
 *
 * All I am doing is taking a rotating object, a box in this case, and subjecting it to an infinite
 * rotation. When the user clicks on the box, it stops rotating.  Ok, so far - so good.  But when the
 * click on it again it resumes rotation exactly where it left off.  That is not so simple.
 *
 */
class StartStopRotation {

    companion object {

        @Composable
        fun StartStopExample(navController: NavHostController) {

            var ndx by remember { mutableStateOf(0) }
            var isIncremented by remember { mutableStateOf(false) }
            var isRotationStop by remember { mutableStateOf(false) }
            var rotation by remember { mutableStateOf(0f) }
            var storedRotationA by remember { mutableStateOf(0f) }
            var clickCount by remember { mutableStateOf(0) }
            val rotationValue = RotationValue()

            // A @Composable function inside! a @Composable function
            // I discovered this!!
            // Basically it stops recursive recomposition
            @Composable
            fun Inside(callback: (Float) -> Unit) {
                rotationValue.DoRotationValue {
                    callback(it)
                }
            }

            // I wonder if future versions of Kotlin / Compose will allow this??
            // In reality, I wrote this but I'm not exactly clear what's happening
            @Composable
            fun Outside(rotation:Float){
                var storedRotationB by remember { mutableStateOf(storedRotationA) }
                storedRotationA = rotation
            }

            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                content = {

                    if (!isRotationStop) {
                        //tricky way to acquire the rotation value from the RotationValue [class]
                            // DoRotationValue [function]
                        Inside {
                            rotation = it + storedRotationA
                            if(rotation >= 360f){
                                rotation %= 360f // mod 360 to ensure the value doesn't keep increasing
                            }
                        }

                        // increment ndx (the total number of rotations)
                        if(rotation in 355f..360f && !isIncremented){
                            isIncremented = true
                            ndx++
                        }
                        // now reset isIncremented for the next rotation
                        if(rotation in 0f..10f){
                            isIncremented = false
                        }

                        // this is the rotating blue box
                        // click on it once, and it stops
                        // click on it again and it continues rotating where it left off
                        Canvas(modifier = Modifier
                            .size(200.dp)
                            .clickable {
                                isRotationStop = true
                                clickCount++
                            }) {
                            rotate(rotation) {
                                drawRect(color = Color(7, 78, 134, 148))
                                val paint = Paint()
                                paint.textSize = 164f
                                paint.color = 0xff000000.toInt()
                                drawIntoCanvas {
                                    it.nativeCanvas.drawText("$ndx [$clickCount]", center.x-200, center.y, paint)
                                }
                            }
                        }
                        // else show the blue box as static and rotated the exact degree
                        // when it was clicked on
                    } else {
                        Outside(rotation)
                        Canvas(modifier = Modifier
                            .size(200.dp)
                            .clickable {
                                isRotationStop = false
                            }) {
                            rotate(rotation) {
                                drawRect(color = Color(7, 78, 134, 148))
                                val paint = Paint()
                                paint.textSize = 164f
                                paint.color = 0xff000000.toInt()
                                drawIntoCanvas {
                                    it.nativeCanvas.drawText("$ndx [$clickCount]", center.x-200, center.y, paint)
                                }
                            }
                        }
                    }

                    // allow navigation back to Main Menu
                    NavIcon.MenuIcon(navController = navController)
                })
        }
    }


} // end class

/**
 * Cycles between 0f - 360f indefinitely and sends the value to a @Composable that needs to rotate
 */
class RotationValue {
    @Composable
    fun DoRotationValue(callback: (Float) -> Unit) {

        val myEasing = CubicBezierEasing(0f, 0f, 0f, 0f) // linear - no jumps

        val infiniteTransition = rememberInfiniteTransition()

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
        callback(rotation)
    }


} // end class