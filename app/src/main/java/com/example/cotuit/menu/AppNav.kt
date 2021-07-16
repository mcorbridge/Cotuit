package com.example.cotuit.menu

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


/**
 * You found it!
 * Now Crtl cursor over the corresponding NavRoutes fn and click
 */

class AppNav {

    companion object{
        @Composable
        fun NavigationInit(navController:NavHostController){

            NavHost(navController = navController, startDestination = Routes.MENU.route) {
                composable(Routes.MENU.route) { NavRoutes.Menu(navController) }
                composable(Routes.WHO_BUILT.route) { NavRoutes.WhoBuilt(navController) }
                composable(Routes.SWITCHING_SQUARES.route) { NavRoutes.SwitchingSquares(navController) }
                composable(Routes.ROTATING_SQUARE.route) { NavRoutes.RotatingSquare(navController) }
                composable(Routes.MOVING_SQUARE.route) { NavRoutes.MovingBox(navController)}
                composable(Routes.TEST_MENU.route) { NavRoutes.TestMenuView(navController)}
                composable(Routes.START_STOP.route) { NavRoutes.StartStop(navController)}
                composable(Routes.PLAYING_WITH.route) { NavRoutes.PlayingWith(navController)}
            }
        }
    }





}