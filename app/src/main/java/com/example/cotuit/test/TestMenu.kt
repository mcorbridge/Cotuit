package com.example.cotuit.test

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.cotuit.menu.NavIcon

class TestMenu {



    companion object{

        @Composable
        fun DoTestMenu(navController: NavHostController) {
            NavIcon.MenuIcon(navController)
        }

    }

}