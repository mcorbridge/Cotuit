package com.example.cotuit.menu

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.*
import com.example.cotuit.network.NetworkMonitor


/**
 * You found it!
 * Now Crtl cursor over the corresponding NavRoutes fn and click
 * Elvis operator: val list = mutableList ?: mutableListOf()
 */

class AppNav {

    companion object{
        @RequiresApi(Build.VERSION_CODES.R)
        @Composable
        fun NavigationInit(navController: NavHostController, isNetworkAvailable: Boolean){

            Column{

                NetworkMonitor.ShowNetworkAvailability(isNetworkAvailable)

                NavHost(navController = navController, startDestination = Routes.MENU.route) {
                    composable(Routes.MENU.route) { NavRoutes.Menu(navController) }
                    composable(Routes.WHO_BUILT.route) { NavRoutes.WhoBuilt(navController) }
                    composable(Routes.SWITCHING_SQUARES.route) { NavRoutes.SwitchingSquares(navController) }
                    composable(Routes.ROTATING_SQUARE.route) { NavRoutes.RotatingSquare(navController) }
                    composable(Routes.MOVING_SQUARE.route) { NavRoutes.MovingBox(navController)}
                    composable(Routes.TEST_MENU.route) { NavRoutes.TestMenuView(navController)}
                    composable(Routes.START_STOP.route) { NavRoutes.StartStop(navController)}
                    composable(Routes.PLAYING_WITH.route) { NavRoutes.PlayingWith(navController)}
                    composable(Routes.TRANSITIONS.route) { NavRoutes.Transitions(navController)}
                    composable(Routes.BOX_WITH_CONSTRAINTS.route) { NavRoutes.ConstrainedBox(navController)}
                    composable(Routes.SLIDE_SHOW.route) { NavRoutes.SlideShow(navController)}
                    composable(Routes.FOOD_2_FORK.route) {NavRoutes.Food2Fork(navController = navController)}
                    composable(Routes.FOO.route) {NavRoutes.TestFoo(navController = navController)}
                    composable(Routes.TEST_HILT.route) {NavRoutes.TestHiltX(navController = navController)}
                }
            }


        }
    }





}