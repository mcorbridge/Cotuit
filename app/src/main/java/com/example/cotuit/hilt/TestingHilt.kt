package com.example.cotuit.hilt

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

class TestingHilt {

    companion object{


        @Composable
        fun DoTestHilt(navController: NavHostController) {
            Text("Testing Hilt")
        }


    }




}