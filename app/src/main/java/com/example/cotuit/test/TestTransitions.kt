package com.example.cotuit.test

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.cotuit.R
import com.example.cotuit.menu.NavIcon

class TestTransitions {

    companion object {

        @Composable
        fun DoTestTransitions(navController: NavHostController) {

            Box(modifier = Modifier.fillMaxSize()) {
                DoTestOne(navController)
            }
        }


        @Composable
        fun DoTestOne(navController: NavHostController) {

            var alphaState0 by remember { mutableStateOf(AlphaState.INIT) }
            var alphaState1 by remember { mutableStateOf(AlphaState.STARTED) }
            var switchBoxHeight by remember { mutableStateOf(10.dp) }
            var isIncrement by remember { mutableStateOf(true) }

            val alphaTransition0: Float by animateFloatAsState(
                targetValue = if (alphaState0 == AlphaState.INIT) 0f else 1f,
                animationSpec = tween(1000),
                finishedListener = { println("I'm finished") })

            val alphaTransition1: Float by animateFloatAsState(
                targetValue = if (alphaState1 == AlphaState.STARTED) 1f else 0f,
                animationSpec = tween(1000),
                finishedListener = { println("I'm finished") })

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(Color(0x7E961642))
            ) {
                Row(
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .height(50.dp)
                        .border(width = 2.dp, color = Color.Black)
                        .fillMaxWidth()
                        .background(Color(0xFF94B1C9))
                ) {
                    Box(modifier = Modifier.width(50.dp)){
                        NavIcon.MenuIcon(navController = navController)
                    }

                    Divider(color = Color.Black, modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp))

                    Divider(color = Color.Black, modifier = Modifier.fillMaxHeight().width(2.dp))

                    Divider(color = Color.Black, modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp))
                    Text("Stuff")
                    Divider(color = Color.Black, modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp))
                    Text("Stuff")
                    Divider(color = Color.Black, modifier = Modifier
                        .fillMaxHeight()
                        .width(2.dp))
                    Text("Stuff")
                }

                Box {

                    Image(
                        painter = painterResource(R.drawable.circle_arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .alpha(alphaTransition0)
                    )

                    Image(
                        painter = painterResource(R.drawable.circle_arrow),
                        contentDescription = null,
                        modifier = Modifier
                            .alpha(alphaTransition1)
                            .rotate(180f)
                    )
                }
                Column {

                    Box {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black.copy(alpha = alphaTransition0))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.LightGray.copy(alpha = alphaTransition1))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                    }
                    Box {
                        Box(
                            modifier = Modifier
                                .background(color = Color.LightGray.copy(alpha = alphaTransition0))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black.copy(alpha = alphaTransition1))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                    }
                    Box {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black.copy(alpha = alphaTransition0))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.LightGray.copy(alpha = alphaTransition1))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                    }
                    Box {
                        Box(
                            modifier = Modifier
                                .background(color = Color.LightGray.copy(alpha = alphaTransition0))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black.copy(alpha = alphaTransition1))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                    }
                    Box {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black.copy(alpha = alphaTransition0))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.LightGray.copy(alpha = alphaTransition1))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                    }
                    Box {
                        Box(
                            modifier = Modifier
                                .background(color = Color.LightGray.copy(alpha = alphaTransition0))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black.copy(alpha = alphaTransition1))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                    }
                    Box {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black.copy(alpha = alphaTransition0))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.LightGray.copy(alpha = alphaTransition1))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                    }
                    Box {
                        Box(
                            modifier = Modifier
                                .background(color = Color.LightGray.copy(alpha = alphaTransition0))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black.copy(alpha = alphaTransition1))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                    }
                    Box {
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black.copy(alpha = alphaTransition0))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.LightGray.copy(alpha = alphaTransition1))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                    }
                    Box {
                        Box(
                            modifier = Modifier
                                .background(color = Color.LightGray.copy(alpha = alphaTransition0))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                        Box(
                            modifier = Modifier
                                .background(color = Color.Black.copy(alpha = alphaTransition1))
                                .height(switchBoxHeight)
                                .fillMaxWidth()
                        )
                    }
                }


                Row {
                    Button(onClick = {
                        if (alphaState0 == AlphaState.INIT) {
                            alphaState0 = AlphaState.STARTED
                            alphaState1 = AlphaState.INIT
                        } else {
                            alphaState0 = AlphaState.INIT
                            alphaState1 = AlphaState.STARTED
                        }
                    }) {
                        Text("switch")
                    }



                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = {
                        if (isIncrement) switchBoxHeight += 1.dp else switchBoxHeight -= 1.dp
                    }) {
                        Text("height")
                    }

                    SimpleRadioGroupTextItemComponent() {
                        println(it)
                        isIncrement = it == "Increment"
                    }
                }
            }
        }

        @Composable
        fun SimpleRadioGroupTextItemComponent(callback: (String) -> Unit) {
            var selected by remember { mutableStateOf("Increment") }

            val radioGroupOptions = listOf<String>("Increment", "Decrement")

            val onSelectedChange = { text: String ->
                selected = text
                callback(selected)
            }

            Column {
                radioGroupOptions.forEach { text ->
                    Row(Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (text == selected),
                            onClick = { onSelectedChange(text) }
                        )
                        .padding(horizontal = 16.dp)
                    ) {
                        RadioButton(
                            selected = (text == selected),
                            onClick = { onSelectedChange(text) }
                        )
                        Text(
                            text = text,
                            style = MaterialTheme.typography.body1.merge(),
                            modifier = Modifier.padding(start = 16.dp)
                        )
                    }
                }
            }
        }

        @Composable
        fun TestBoxWithConstraints(navController: NavHostController) {

            var xPos by remember { mutableStateOf(0.dp) }
            var yPos by remember { mutableStateOf(0.dp) }
            var rotation by remember { mutableStateOf(0f) }
            var _minHeight by remember { mutableStateOf(0.dp) }
            var _maxHeight by remember { mutableStateOf(0.dp) }
            var _minWidth by remember { mutableStateOf(0.dp) }
            var _maxWidth by remember { mutableStateOf(0.dp) }

            Column(
                modifier = Modifier
                    .border(2.dp, Color.Black)
                    .fillMaxSize()
                    .background(Color(0x6AA3C57C))
            ) {


                Text(
                    "Testing Box with Constraints (Do I really understand this? No...",
                    modifier = Modifier
                        .offset(x = 25.dp, y = 10.dp)
                )

                BoxWithConstraints(
                    modifier = Modifier
                        .offset(x = xPos, y = yPos)
                        .rotate(rotation)
                        .background(Color(0x4D54ABB6))
                ) {
                    _minHeight = minHeight
                    _maxHeight = maxHeight
                    _minWidth = minWidth
                    _maxWidth = maxWidth
                    Box(
                        modifier = Modifier
                            .border(2.dp, Color.Black)
                            .height(200.dp)
                            .width(200.dp)
                            .padding(all = 10.dp)
                            .background(Color(0xFF9B2B07))
                    ) {

                        Text(
                            "x=$xPos\ny=$yPos\nr=$rotation\n" +
                                    "minHeight = $_minHeight\n" +
                                    "maxHeight = $_maxHeight\n" +
                                    "minWidth = $_minWidth\n" +
                                    "maxWidth = $_maxWidth",
                            color = Color.White, modifier = Modifier
                        )
                    }

                }

                Row(modifier = Modifier.padding(3.dp)) {
                    Button(onClick = {
                        xPos += 10.dp
                    }) {
                        Text("x++")
                    }
                    Spacer(modifier = Modifier.width(3.dp))
                    Button(onClick = {
                        yPos += 10.dp
                    }) {
                        Text("y++")
                    }
                    Spacer(modifier = Modifier.width(3.dp))
                    Button(onClick = {
                        rotation += 5f
                        if (rotation > 360) {
                            rotation -= 360
                        }
                    }) {
                        Text("r++")
                    }
                }
                Row {
                    Button(onClick = {
                        xPos -= 10.dp
                    }) {
                        Text("x--")
                    }
                    Spacer(modifier = Modifier.width(3.dp))
                    Button(onClick = {
                        yPos -= 10.dp
                    }) {
                        Text("y--")
                    }
                    Spacer(modifier = Modifier.width(3.dp))
                    Button(onClick = {
                        rotation -= 5f
                        if (rotation < 0) {
                            rotation += 360
                        }
                    }) {
                        Text("r--")
                    }
                }

            }


            // allow navigation back to Main Menu
            NavIcon.MenuIcon(navController = navController)

        }

    }
}



enum class AlphaState {
    INIT, STARTED
}