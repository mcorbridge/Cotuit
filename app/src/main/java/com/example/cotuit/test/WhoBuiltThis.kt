package com.example.cotuit.test

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cotuit.menu.NavIcon

class WhoBuiltThis {


    companion object{
        @Composable
        fun About(navController: NavHostController){

            Box(modifier = Modifier.fillMaxSize().background(Color(0xA379AEB4))) {

                Column(modifier = Modifier.fillMaxWidth()){
                    // allow navigation back to Main Menu
                    NavIcon.MenuIcon(navController = navController)

                    Text("Who built this anyway?", fontWeight = FontWeight.ExtraBold, fontSize = 32.sp)
                    Text("(and why?)", fontWeight = FontWeight.Bold, fontSize = 28.sp)
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Me.  I built it. Mike Corbridge - mikecorbridge@gmail.com")

                    Text("Jetpack compose is a modern Android UI toolkit introduced by Google. " +
                            " It simplifies the app development process and speeds it up. With Jetpack " +
                            "Compose, you can write less code compared to the current view building " +
                            "approach – which also means less potential bugs. There is one more " +
                            "great thing about it – it uses Kotlin. If you have been using React or " +
                            "Flutter, you will probably be familiar with the concept and find many " +
                            "similarities.")

                    Text("A main building block of Compose is the Composable function. " +
                            "It emits a part of the user interface. Building with Compose is about " +
                            "nesting the Composable functions in each other.")

                    Text("Jetpack Compose is built upon a different programming paradigm. It " +
                            "uses a declarative paradigm. To put it shortly, it means that you have " +
                            "to change your way of thinking from: “How to do something” to “What " +
                            "goal I want to achieve”. In a declarative way of programming, you try " +
                            "to describe an expected result instead of describing every step to achieve " +
                            "the goal. In the previous example we simply said “I want to have a column " +
                            "with three texts inside” – and that is all. We don’t need to write any " +
                            "extra code that tells the app how to deal with the items inside the column.")

                }




            }

        }
    }


}