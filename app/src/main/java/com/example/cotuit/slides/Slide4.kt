package com.example.cotuit.slides

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.cotuit.test.MyDataClass
import com.example.cotuit.test.SlideState

class Slide4 {

    companion object{

        @Composable
        fun Slide(slideState: SlideState, dataClass: MyDataClass?= null){

            var slideTarget by remember { mutableStateOf((-400).dp) }

            var eh by remember {
                mutableStateOf(A())
            }

            if(slideState == SlideState.SLIDE_3){
                slideTarget = (-400).dp
            }
            if(slideState == SlideState.SLIDE_5){
                slideTarget = 400.dp
            }

            val slideAnimation: Dp by animateDpAsState(
                targetValue = if (slideState == SlideState.SLIDE_4) 0.dp else slideTarget,
                animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = 100f),
                finishedListener = { println("slide4Animation finished") })

            Box(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .offset(x = slideAnimation, y = 0.dp)
                .background(Color(0xFF03A9F4))){

                Column{
                    Text("Slide #4 - Qualified this")
                    Text("To denote the current receiver, you use this expressions:\n" +
                            "\n" +
                            "In a member of a class, this refers to the current object of that class.\n" +
                            "\n" +
                            "In an extension function or a function literal with receiver this denotes the receiver parameter that is passed on the left-hand side of a dot.\n" +
                            "\n" +
                            "If this has no qualifiers, it refers to the innermost enclosing scope. To refer to this in other scopes, label qualifiers are used:\n\n" +
                            "To see this running, you need to review the debug ouput.  There is really nothing to show - it is all about the mechanisms of Kotlin.")

                    Button(onClick = {
                        var a = A()

                    }) {
                        Text("Do Qualified *this*")
                    }

                }


            }

            var bar = eh.B().z
        }
    }
}

class A { // implicit label @A

    init{
        println("init A")
        doC()
    }


    var z = "z"

    fun doC(){
        println("doC()")
        var c = C()
        c.doBar()
        c.bar
    }




    inner class B {

        init{
            println("init B")
        }


        var z = "z"
        // implicit label @B
        fun Int.foo() { // implicit label @foo
            val a = this@A // A's this
            val b = this@B // B's this

            b.z = "ZZZZZZZZZZZZZZZZZZZZZZZZZZZZZ"
            a.z = "zzzzzzzzzzzzzzzzz"

            val c = this // foo()'s receiver, an Int
            val c1 = this@foo // foo()'s receiver, an Int

            val funLit = lambda@ fun String.() {
                val d = this // funLit's receiver
            }

            val funLit2 = { s: String ->
                // foo()'s receiver, since enclosing lambda expression
                // doesn't have any receiver
                val d1 = this
            }

            val zoop = {

            }
        }
    }

    // cannot be accessed ANYWHERE except inside of A()
    private inner class C{

        var numKraken = 0

        init{
            println("init C")
        }

        var z = ""
        var c:C = this@C

        fun foo(){
            c.z = "CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC"
        }

        val bar = lambda@ {
            println("lambda bar")
        }

        fun doBar(){
            println("---> doBar")
            println("---> start Kraken")
            kraken()
            kraken = { println("The Kraken was released!") }
            kraken()
            println("---> end Kraken")
        }

        var kraken = {
            numKraken++
            println("Release the Kraken!")
        }
    }
}