package com.example.cotuit.test

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cotuit.R
import com.example.cotuit.menu.NavIcon

/**
 * In which a clever little example app is created to show all the 'Spring' api options
 * (for whatever that is worth)
 * It is all, "Perfectly Splendid!"
 *
 * I love Jetpack Compose.
 * Once you get your head around 'Thinking in Compose' it makes writing
 * (relatively) complex code (much) less onerous.
 */

class PlayingWithAnimationSpec {

    companion object {

        @Composable
        fun DoPlayingWithAnimationSpec(navController: NavHostController) {

            var springBoxWidth by remember { mutableStateOf(0f) }
            var keyframeBoxWidth by remember { mutableStateOf(0f) }
            var snapBoxWidth by remember { mutableStateOf(0f) }
            var springBoxColor by remember { mutableStateOf(0xFF009688) } // alt 0xFFFF5722
            var keyframeColor by remember { mutableStateOf(0xFF009688) }
            var snapColor by remember { mutableStateOf(0xFF009688) }

            //Inner function
            fun viewController(view: String) {
                springBoxWidth = 0f
                keyframeBoxWidth = 0f
                snapBoxWidth = 0f
                springBoxColor = 0xFF009688
                keyframeColor = 0xFF009688
                snapColor = 0xFF009688
                when (view) {

                    "spring" -> {
                        springBoxWidth = 1f
                        springBoxColor = 0xFFFF5722
                    }
                    "keyframe" -> {
                        keyframeBoxWidth = 1f
                        keyframeColor = 0xFFFF5722
                    }
                    "snap" -> {
                        snapBoxWidth = 1f
                        snapColor = 0xFFFF5722
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xCBB2D886))
            ) {

                Column {

                    // allow navigation back to Main Menu
                    NavIcon.MenuIcon(navController = navController)

                    Row {
                        Text(
                            "Spring, ",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 32.sp,
                            color = Color(springBoxColor),
                            modifier = Modifier.clickable {
                                viewController("spring")
                            }
                        )
                        Text(
                            "Keyframes, ",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 32.sp,
                            color = Color(keyframeColor),
                            modifier = Modifier.clickable {
                                viewController("keyframe")
                            }
                        )
                        Text(
                            "and Snap",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 32.sp,
                            color = Color(snapColor),
                            modifier = Modifier.clickable {
                                viewController("snap")
                            }
                        )
                    }

                    Box(Modifier.fillMaxWidth()) {
                        Box(modifier = Modifier.fillMaxWidth(springBoxWidth)) {
                            Spring()
                        }

                        Box(modifier = Modifier.fillMaxWidth(keyframeBoxWidth)) {
                            KeyFrame()
                        }

                        Box(modifier = Modifier.fillMaxWidth(snapBoxWidth)) {
                            Snap()
                        }
                    }
                }
            }
        }

        @Composable
        fun Spring() {

            var boxState0 by remember { mutableStateOf(TestBoxPosition.INIT) }
            var boxState1 by remember { mutableStateOf(TestBoxPosition.INIT) }
            var boxState2 by remember { mutableStateOf(TestBoxPosition.INIT) }
            var boxState3 by remember { mutableStateOf(TestBoxPosition.INIT) }
            var boxState4 by remember { mutableStateOf(TestBoxPosition.INIT) }
            var boxState5 by remember { mutableStateOf(TestBoxPosition.INIT) }
            var boxState6 by remember { mutableStateOf(TestBoxPosition.INIT) }
            var boxState7 by remember { mutableStateOf(TestBoxPosition.INIT) }
            var boxState8 by remember { mutableStateOf(TestBoxPosition.INIT) }

            val offsetAnimation0: Dp by animateDpAsState(
                if (boxState0 == TestBoxPosition.INIT) 5.dp else 300.dp,
                spring(dampingRatio = Spring.StiffnessHigh)
            )

            val offsetAnimation1: Dp by animateDpAsState(
                if (boxState1 == TestBoxPosition.INIT) 5.dp else 300.dp,
                spring(dampingRatio = Spring.StiffnessMedium)
            )

            val offsetAnimation2: Dp by animateDpAsState(
                if (boxState2 == TestBoxPosition.INIT) 5.dp else 300.dp,
                spring(dampingRatio = Spring.StiffnessLow)
            )

            val offsetAnimation3: Dp by animateDpAsState(
                if (boxState3 == TestBoxPosition.INIT) 5.dp else 300.dp,
                spring(dampingRatio = Spring.StiffnessVeryLow)
            )

            val offsetAnimation4: Dp by animateDpAsState(
                if (boxState4 == TestBoxPosition.INIT) 5.dp else 300.dp,
                spring(dampingRatio = Spring.DampingRatioHighBouncy)
            )

            val offsetAnimation5: Dp by animateDpAsState(
                if (boxState5 == TestBoxPosition.INIT) 5.dp else 300.dp,
                spring(dampingRatio = Spring.DampingRatioMediumBouncy)
            )

            val offsetAnimation6: Dp by animateDpAsState(
                if (boxState6 == TestBoxPosition.INIT) 5.dp else 300.dp,
                spring(dampingRatio = Spring.DampingRatioLowBouncy)
            )

            val offsetAnimation7: Dp by animateDpAsState(
                if (boxState7 == TestBoxPosition.INIT) 5.dp else 300.dp,
                spring(dampingRatio = Spring.DampingRatioNoBouncy)
            )

            val offsetAnimation8: Dp by animateDpAsState(
                if (boxState8 == TestBoxPosition.INIT) 5.dp else 300.dp,
                spring(dampingRatio = Spring.DefaultDisplacementThreshold)
            )

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy((-10).dp)
            ) {

                BouncyElement(offsetAnimation0, "StiffnessHigh", boxState0) {
                    boxState0 = it
                }

                BouncyElement(offsetAnimation1, "StiffnessMedium", boxState1) {
                    boxState1 = it
                }

                BouncyElement(offsetAnimation2, "StiffnessLow", boxState2) {
                    boxState2 = it
                }

                BouncyElement(offsetAnimation3, "StiffnessVeryLow", boxState3) {
                    boxState3 = it
                }

                BouncyElement(offsetAnimation4, "DampingRatioHighBouncy", boxState4) {
                    boxState4 = it
                }

                BouncyElement(offsetAnimation5, "DampingRatioLowBouncy", boxState5) {
                    boxState5 = it
                }

                BouncyElement(offsetAnimation6, "DampingRatioMediumBouncy", boxState6) {
                    boxState6 = it
                }

                BouncyElement(offsetAnimation7, "DampingRatioNoBouncy", boxState7) {
                    boxState7 = it
                }

                BouncyElement(offsetAnimation8, "DefaultDisplacementThreshold", boxState8) {
                    boxState8 = it
                }

            }
        }

        @Composable
        fun BouncyElement(
            absoluteOffset: Dp,
            description: String,
            state: TestBoxPosition,
            callback: (TestBoxPosition) -> Unit
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.circle_arrow),
                    contentDescription = null,
                    modifier = Modifier
                        .height(90.dp)
                        .absoluteOffset(x = absoluteOffset)
                        .clickable {
                            when (state) {
                                TestBoxPosition.INIT -> callback(TestBoxPosition.START)
                                TestBoxPosition.START -> callback(TestBoxPosition.INIT)
                            }

                        }
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(description)
            }
        }
    }
}

@Composable
fun KeyFrame() {
    Text("keyframe TODO")
}

@Composable
fun Snap() {
    Text("snap TODO")
}


enum class TestBoxPosition {
    INIT, START
}