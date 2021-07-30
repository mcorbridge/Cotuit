package com.example.cotuit.menu

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.cotuit.food2Fork.FoodToFork
import com.example.cotuit.hilt.TestingHilt
import com.example.cotuit.test.*

class NavRoutesToo {

    companion object {


        @Composable
        fun TestHiltX(navController: NavHostController) {
            //TestingHilt.DoTestHilt(navController = navController)
        }

        @Composable
        fun TestFoo(navController: NavHostController) {
            println("Foooooo???????")
        }


    }


}