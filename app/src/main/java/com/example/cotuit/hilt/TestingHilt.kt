package com.example.cotuit.hilt

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.cotuit.menu.NavIcon
import com.example.cotuit.util.ConnectivityManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class TestingHilt {





    init{
        println(":::::::::::::::::::::::::::::::::::::: init")
    }



    @Composable
    fun DoTestHilt(navController: NavHostController) {


        Column{
            // allow navigation back to Main Menu
            NavIcon.MenuIcon(navController = navController)

            Text("Testing Hilt")

        }


    }


    companion object{

        // Dagger does not support injection into static fields
        // @Inject lateinit var testInject: TestInject

        init{
            println(":::::::::::::::::::::::::::::::::::: init companion object")

        }


        @Composable
        fun DoTestHilt(navController: NavHostController) {

            Column{
                // allow navigation back to Main Menu
                NavIcon.MenuIcon(navController = navController)

                Text("Testing Hilt")

                //testInject.DoTestInject()
            }


        }


    }




}