package com.example.cotuit.test

import androidx.compose.animation.core.*
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
            var tweenBoxWidth by remember { mutableStateOf(0f) }
            var keyframeBoxWidth by remember { mutableStateOf(0f) }
            var snapBoxWidth by remember { mutableStateOf(0f) }
            var springColor by remember { mutableStateOf(0xFF009688) } // alt 0xFFFF5722
            var tweenColor by remember { mutableStateOf(0xFF009688) }
            var keyframeColor by remember { mutableStateOf(0xFF009688) }
            var snapColor by remember { mutableStateOf(0xFF009688) }

            //Inner function
            fun viewController(view: String) {
                springBoxWidth = 0f
                tweenBoxWidth = 0f
                keyframeBoxWidth = 0f
                snapBoxWidth = 0f
                springColor = 0xFF009688
                tweenColor = 0xFF009688
                keyframeColor = 0xFF009688
                snapColor = 0xFF009688
                when (view) {

                    "spring" -> {
                        springBoxWidth = 1f
                        springColor = 0xFFFF5722
                    }
                    "tween" -> {
                        tweenBoxWidth = 1f
                        tweenColor = 0xFFFF5722
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

                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            "Spring, ",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 22.sp,
                            color = Color(springColor),
                            modifier = Modifier.clickable {
                                viewController("spring")
                            }
                        )
                        Text(
                            "Tween, ",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 22.sp,
                            color = Color(tweenColor),
                            modifier = Modifier.clickable {
                                viewController("tween")
                            }
                        )
                        Text(
                            "Keyframes, ",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 22.sp,
                            color = Color(keyframeColor),
                            modifier = Modifier.clickable {
                                viewController("keyframe")
                            }
                        )
                        Text(
                            "and ", fontWeight = FontWeight.ExtraBold,
                            fontSize = 18.sp,
                            color = Color(0xFF009688),
                        )
                        Text(
                            " Snap",
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 22.sp,
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

                        Box(modifier = Modifier.fillMaxWidth(tweenBoxWidth)) {
                            Tween()
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
fun Tween() {

    var arrowPosition by remember { mutableStateOf(ArrowPosition.INIT) }

    val offsetAnimation0: Dp by animateDpAsState(
        if (arrowPosition == ArrowPosition.INIT) 0.dp else 360.dp,
        tween(1000, easing = FastOutSlowInEasing)
    )

    val offsetAnimation1: Dp by animateDpAsState(
        if (arrowPosition == ArrowPosition.INIT) 0.dp else 360.dp,
        tween(1000, easing = LinearEasing)
    )

    val offsetAnimation2: Dp by animateDpAsState(
        if (arrowPosition == ArrowPosition.INIT) 0.dp else 360.dp,
        tween(1000, easing = FastOutLinearInEasing)
    )

    val offsetAnimation3: Dp by animateDpAsState(
        if (arrowPosition == ArrowPosition.INIT) 0.dp else 360.dp,
        tween(1000, easing = LinearOutSlowInEasing)
    )

    val offsetAnimation4: Dp by animateDpAsState(
        if (arrowPosition == ArrowPosition.INIT) 0.dp else 360.dp,
        tween(1000, easing = CubicBezierEasing(0.4f, 0.0f, 0.8f, 0.8f))
    )


    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy((-10).dp)
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
                    .absoluteOffset(x = offsetAnimation0)
                    .clickable {
                        when (arrowPosition) {
                            ArrowPosition.INIT -> {
                                arrowPosition = ArrowPosition.START
                            }
                            ArrowPosition.START -> {
                                arrowPosition = ArrowPosition.INIT
                            }
                        }
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text("tween(1000, FastOutSlowInEasing)")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.circle_arrow),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .absoluteOffset(x = offsetAnimation1)
                    .clickable {
                        when (arrowPosition) {
                            ArrowPosition.INIT -> {
                                arrowPosition = ArrowPosition.START
                            }
                            ArrowPosition.START -> {
                                arrowPosition = ArrowPosition.INIT
                            }
                        }
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text("tween(1000, LinearEasing)")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.circle_arrow),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .absoluteOffset(x = offsetAnimation2)
                    .clickable {
                        when (arrowPosition) {
                            ArrowPosition.INIT -> {
                                arrowPosition = ArrowPosition.START
                            }
                            ArrowPosition.START -> {
                                arrowPosition = ArrowPosition.INIT
                            }
                        }
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text("tween(1000, FastOutLinearInEasing)")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.circle_arrow),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .absoluteOffset(x = offsetAnimation3)
                    .clickable {
                        when (arrowPosition) {
                            ArrowPosition.INIT -> {
                                arrowPosition = ArrowPosition.START
                            }
                            ArrowPosition.START -> {
                                arrowPosition = ArrowPosition.INIT
                            }
                        }
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text("tween(1000, LinearOutSlowInEasing)")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.circle_arrow),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .absoluteOffset(x = offsetAnimation4)
                    .clickable {
                        when (arrowPosition) {
                            ArrowPosition.INIT -> {
                                arrowPosition = ArrowPosition.START
                            }
                            ArrowPosition.START -> {
                                arrowPosition = ArrowPosition.INIT
                            }
                        }
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text("tween(1000, Custom Bezier)")
        }
    }
}

@Composable
fun KeyFrame() {

    var arrowPosition by remember { mutableStateOf(ArrowPosition.INIT) }

    val offsetAnimation0: Dp by animateDpAsState(
        if (arrowPosition == ArrowPosition.INIT) 0.dp else 360.dp,

        keyframes {
            durationMillis = 1000
            100.dp.at(500)
        })

    val offsetAnimation1: Dp by animateDpAsState(
        if (arrowPosition == ArrowPosition.INIT) 0.dp else 360.dp,
        keyframes {
            durationMillis = 3000
            50.dp.at(20).with(LinearEasing)
            200.dp.at(600).with(LinearOutSlowInEasing)
            250.dp.at(700).with(FastOutSlowInEasing)
        })

    val offsetAnimation2: Dp by animateDpAsState(
        if (arrowPosition == ArrowPosition.INIT) 0.dp else 360.dp,
        repeatable(iterations = 5, animation = tween(5000), repeatMode = RepeatMode.Restart)
    )

    val offsetAnimation3: Dp by animateDpAsState(
        if (arrowPosition == ArrowPosition.INIT) 0.dp else 360.dp,
        repeatable(iterations = 5, animation = tween(5000), repeatMode = RepeatMode.Reverse)
    )

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy((-10).dp)
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
                    .absoluteOffset(x = offsetAnimation0)
                    .clickable {
                        when (arrowPosition) {
                            ArrowPosition.INIT -> {
                                arrowPosition = ArrowPosition.START
                            }
                            ArrowPosition.START -> {
                                arrowPosition = ArrowPosition.INIT
                            }
                        }
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text("1000ms total, 100dp at 500ms")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.circle_arrow),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .absoluteOffset(x = offsetAnimation1)
                    .clickable {
                        when (arrowPosition) {
                            ArrowPosition.INIT -> {
                                arrowPosition = ArrowPosition.START
                            }
                            ArrowPosition.START -> {
                                arrowPosition = ArrowPosition.INIT
                            }
                        }
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text("total 3000ms 50dp at 20ms (LinearEasing) 200dp at 600ms (LinearOutSlowInEasing) 300dp at 700ms (FastOutSlowInEasing")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.circle_arrow),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .absoluteOffset(x = offsetAnimation2)
                    .clickable {
                        when (arrowPosition) {
                            ArrowPosition.INIT -> {
                                arrowPosition = ArrowPosition.START
                            }
                            ArrowPosition.START -> {
                                arrowPosition = ArrowPosition.INIT
                            }
                        }
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(" repeatable(iterations = 5, animation = tween(5000), repeatMode = RepeatMode.Restart)")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(R.drawable.circle_arrow),
                contentDescription = null,
                modifier = Modifier
                    .height(90.dp)
                    .absoluteOffset(x = offsetAnimation3)
                    .clickable {
                        when (arrowPosition) {
                            ArrowPosition.INIT -> {
                                arrowPosition = ArrowPosition.START
                            }
                            ArrowPosition.START -> {
                                arrowPosition = ArrowPosition.INIT
                            }
                        }
                    }
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(" repeatable(iterations = 5, animation = tween(5000), repeatMode = RepeatMode.Reverse)")
        }
    }
}

@Composable
fun Snap() {
    Text("snap TODO")
}


enum class TestBoxPosition {
    INIT, START
}

enum class ArrowPosition {
    INIT, START
}