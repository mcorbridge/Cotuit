package com.example.cotuit.kotlinIdioms

import androidx.compose.runtime.Composable

class PlayingWithKotlinIdioms {

    companion object{

        lateinit var a: String

        /**
         * lazy() is a function that takes a lambda and returns an instance of Lazy<T> which
         * can serve as a delegate for implementing a lazy property: the first call to get()
         * executes the lambda passed to lazy() and remembers the result, subsequent calls to
         * get() simply return the remembered result.
         */


        private val lazyValue: String by lazy {
            println("computed!")
            "Hello"
        }

        @Composable
        fun DoPlay(){
            println("lazyValue  $lazyValue")
            println("lazyValue  $lazyValue")
        }



    } // end companion object




} // end class

