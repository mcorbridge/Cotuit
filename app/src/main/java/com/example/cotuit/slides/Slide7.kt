package com.example.cotuit.slides

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
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
                                    coroutineScope.launch { state.drawerState.open() }
                                }))
                        },
                        elevation = 16.dp,
                    )
                },
                drawerShape = MaterialTheme.shapes.large,
                drawerElevation = 16.dp,
                drawerContent = {
                    Text(text = "Drawer")
                    Icon(Icons.Default.Mail, contentDescription = "Localized description",
                        modifier = Modifier.clickable(onClick = {
                            coroutineScope.launch { state.drawerState.close() }
                            coroutineScope.launch { state.snackbarHostState.showSnackbar("zzzzzip! The drawer closed.") }
                        }))
                }
            ) {
                ScaffoldBody()
            }
        }

        @Composable
        fun ScaffoldBody(){
            Column{
                Text("In Compose, the UI is immutable—there's no way to update it after it's been " +
                        "drawn. What you can control is the state of your UI. Every time the state of " +
                        "the UI changes, Compose recreates the parts of the UI tree that have changed. " +
                        "Composables can accept state and expose events—for example, a TextField accepts " +
                        "a value and exposes a callback onValueChange that requests the callback " +
                        "handler to change the value.\n\n" +
                        "Because composables accept state and expose events, the unidirectional " +
                        "data flow pattern fits well with Jetpack Compose. This guide focuses on how " +
                        "to implement the unidirectional data flow pattern in Compose, how to implement " +
                        "events and state holders, and how to work with ViewModels in Compose.\n\n" +
                        "A unidirectional data flow (UDF) is a design pattern where state flows down " +
                        "and events flow up. By following unidirectional data flow, you can decouple " +
                        "composables that display state in the UI from the parts of your app that store " +
                        "and change state.\n" +
                        "\n" +
                        "The UI update loop for an app using unidirectional data flow looks like this:\n" +
                        "\n" +
                        "Event: Part of the UI generates an event and passes it upward, such as a " +
                        "button click passed to the ViewModel to handle; or an event is passed from " +
                        "other layers of your app, such as indicating that the user session has expired.\n" +
                        "Update state: An event handler might change the state.\n" +
                        "Display state: The state holder passes down the state, and the UI displays it.")
            }
        }

    } // end companion object

} // end class

