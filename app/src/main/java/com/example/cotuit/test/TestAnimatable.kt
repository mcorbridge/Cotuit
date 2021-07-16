package com.example.cotuit.test

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerInputChange
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class TestAnimatable {

    @Composable
    fun DoAnimatable() {

        // Creates an `Animatable` to animate Offset and `remember` it.
        /**
         * Animatable is a value holder that automatically animates its value when the value is
         * changed via animateTo. If animateTo is invoked during an ongoing value change animation,
         * a new animation will transition Animatable from its current value (i.e. value at the
         * point of interruption) to the new targetValue. This ensures that the value change is always
         * continuous using animateTo. If a spring animation (e.g. default animation) is used with animateTo,
         * the velocity change will guarantee to be continuous as well.
         * Unlike AnimationState, Animatable ensures mutual exclusiveness on its animations. To achieve
         * this, when a new animation is started via animateTo (or animateDecay), any ongoing animation
         * will be canceled via a CancellationException.
         */
        val animatedOffset = remember {
            Animatable(  // <---------------------------- !!!
                Offset(0f, 0f),
                Offset.VectorConverter
            )
        }

        val animatedZOffset = remember {
            Animatable(  // <---------------------------- !!!
                Offset(10f, 10f),
                Offset.VectorConverter
            )
        }


        fun doFoo(arg: PointerInputChange) {
            println("1) ${arg.position}")
            println("2) ${arg.consumed.downChange}   ${arg.consumed.positionChange}")
            println("3) ${arg.id}")
            println("4) ${arg.pressed}")
            println("5) ${arg.previousPosition}")
            println("6) ${arg.previousPressed}")
            println("7) ${arg.previousUptimeMillis}")
            println("8) ${arg.type}")
            println("9) ${arg.uptimeMillis}")
        }

        Box(
            Modifier
                .fillMaxSize()
                .background(Color(0xffb5fffa))
                .pointerInput(Unit)
                {
                    coroutineScope {


                        while (true) {
                            val offset = awaitPointerEventScope {
                                awaitFirstDown().position
                            }

//                            val foo = awaitPointerEventScope {
//                                doFoo(awaitFirstDown())
//                            }


                            // Launch a new coroutine for animation so the touch detection thread is not
                            // blocked.
                            launch {
                                // Animates to the pressed position, with the given animation spec.
                                animatedZOffset.animateTo(
                                    offset,
                                    animationSpec = spring(stiffness = Spring.StiffnessVeryLow)
                                )
                            }


                        }
                    }
                }
        )
        {
            Text("Tap anywhere", Modifier.align(Alignment.Center))
            Box(
                Modifier
                    .offset {
                        // Use the animated offset as the offset of the Box.
                        //println(animatedZOffset.value)
                        IntOffset(
                            animatedZOffset.value.x.roundToInt(),
                            animatedZOffset.value.y.roundToInt()
                        )
                    }
                    .size(40.dp)
                    .background(Color(0xffe61207), CircleShape)
            ) {
                //println(animatedZOffset.value)
            }
        }
    }
}

class AnimatingTheComposeGalaxy {


    companion object {
        @Composable
        fun FirstThing() {
            val myEasing = CubicBezierEasing(0f, 0f, 0f, 0f)

            var animationTargetState by remember { mutableStateOf(0f) }

            var radius by remember { mutableStateOf(500f) }

            val animSpec: AnimationSpec<Float> = repeatable(
                iterations = 10,
                animation = tween(1000, 100, myEasing),
                repeatMode = RepeatMode.Reverse
            )

            val animatedFloatState: Float by animateFloatAsState(
                targetValue = animationTargetState,
                animationSpec = animSpec,
                finishedListener = {
                    println(it)
                    if (it == 1.0f) {
                        animationTargetState = 0f
                    } else {
                        animationTargetState = 1.0f
                    }
                })

            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Black)
            ) {
                drawCircle(color = Color.White, radius = radius, alpha = animatedFloatState)
            }

            val coroutineScope = rememberCoroutineScope()
            var isCoroutineRun by remember { mutableStateOf(false) }

            val startAnimation: () -> Unit = {
                coroutineScope.launch {
                    isCoroutineRun = true
                    delay(1000)
                    animationTargetState = 1f
                }
            }

            if (!isCoroutineRun) {
                startAnimation()
            }
        }

        @Composable
        fun SecondThing() {
            // Need to remember in order to prevent setting
            // the same state value to the transition during
            // recomposition.
            var animationTargetState by remember {
                mutableStateOf(AnimationState.INIT)
            }

            // Any state change will trigger animations which
            // are created with this transition to the new state
            val transition = updateTransition(
                targetState = animationTargetState, label = "A"
            )

            val circleAlpha: Float by transition.animateFloat(
                transitionSpec = { tween(durationMillis = 3000) }, label = "B"
            ) {
                if (it == AnimationState.INIT) 0f else 1f
            }

            val circleRadius: Float by transition.animateFloat(
                transitionSpec = { tween(durationMillis = 3000) }, label = "C"
            ) {
                if (it == AnimationState.INIT) 0f else 500f
            }

            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .background(Color.Black)
            ) {
                drawCircle(
                    color = Color.White,
                    radius = circleRadius,
                    alpha = circleAlpha
                )

                // Set animation state value to another state to trigger the animation
                // odd that we don't have to leverage a coroutine to start this? okay.....
                animationTargetState = AnimationState.START
            }
        }

        @Composable
        fun ThirdThing() {

//            val infiniteTransition = rememberInfiniteTransition()
//
//            val infinitelyAnimatedAlphaFloat: Float by infiniteTransition.animateFloat(
//                initialValue = 0f,
//                targetValue = 1f,
//                animationSpec = infiniteRepeatable(
//                    animation = tween(),
//                    repeatMode = RepeatMode.Reverse
//                )
//            )
//
//            val infinitelyAnimatedRadiusFloat: Float by infiniteTransition.animateFloat(
//                initialValue = 0f,
//                targetValue = 10f,
//                animationSpec = infiniteRepeatable(
//                    animation = tween(),
//                    repeatMode = RepeatMode.Reverse
//                )
//            )

            Box(modifier = Modifier.fillMaxSize().background(Color.Black)){
                StarBlink0(Pair(10.dp, 10.dp))
                //StarBlink(Pair(100.dp, 100.dp))
                StarBlink1(Pair(500.dp, 500.dp))
            }

        }

        @Composable
        fun StarBlink0(offset:Pair<Dp,Dp>){

            val infiniteTransition0 = rememberInfiniteTransition()

            val infinitelyAnimatedAlphaFloat0: Float by infiniteTransition0.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(),
                    repeatMode = RepeatMode.Reverse
                )
            )

            val infinitelyAnimatedRadiusFloat0: Float by infiniteTransition0.animateFloat(
                initialValue = 0f,
                targetValue = 10f,
                animationSpec = infiniteRepeatable(
                    animation = tween(),
                    repeatMode = RepeatMode.Reverse
                )
            )

            Canvas(
                modifier = Modifier
                    .background(Color.Black)
                    .height(offset.first)
                    .width(offset.second)
                    .offset(x=10.dp, y=10.dp)
            ) {
                drawCircle(
                    color = Color.White,
                    radius = infinitelyAnimatedRadiusFloat0,
                    alpha = infinitelyAnimatedAlphaFloat0
                )
            }
        }

        @Composable
        fun StarBlink1(offset:Pair<Dp,Dp>){

            val infiniteTransition = rememberInfiniteTransition()

            val infinitelyAnimatedAlphaFloat: Float by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = tween(),
                    repeatMode = RepeatMode.Reverse
                )
            )

            val infinitelyAnimatedRadiusFloat: Float by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 10f,
                animationSpec = infiniteRepeatable(
                    animation = tween(),
                    repeatMode = RepeatMode.Reverse
                )
            )

            Canvas(
                modifier = Modifier
                    .background(Color.Black)
                    .height(offset.first)
                    .width(offset.second)
                    .offset(x=10.dp, y=10.dp)
            ) {
                drawCircle(
                    color = Color.White,
                    radius = infinitelyAnimatedRadiusFloat,
                    alpha = infinitelyAnimatedAlphaFloat
                )
            }
        }

        @Composable
        fun FourthThing() {

        }
    }
}

enum class AnimationState {
    INIT, START
}
