package com.example.cotuit.menu

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.cotuit.food2Fork.FoodToFork
import com.example.cotuit.hilt.TestingHilt
import com.example.cotuit.test.*

class NavRoutes {

    companion object {

        private val testWally = TestWally()

        // The *default* screen that appears upon application init
        // It is the 'Main Menu' that provides a column (vertical list)
        // of Cards that describe the sample code.
        // Upon 'click' the UI opens a screen that illustrates the demo.

        /**
         * One step closer!
         * Now do the same (Crtl click) over the function to find the base @Composable
         * that is being displayed in the App
         */
        @Composable
        fun Menu(navController: NavHostController) {
            val appMenu = AppMenu(navController)
            appMenu.MenuButtons()
        }

        @Composable
        fun WhoBuilt(navController: NavHostController) {
            WhoBuiltThis.About(navController = navController)
        }

        @Composable
        fun MovingBox(navController: NavHostController) {
            testWally.MyMovingSquare(navController)
        }

        @Composable
        fun SwitchingSquares(navController: NavHostController) {
            DegreesOfAnimation.SwitchingSquares(navController)
        }

        @Composable
        fun RotatingSquare(navController: NavHostController) {
            testWally.MyRotatingSquare(navController)
        }

        @Composable
        fun TestMenuView(navController: NavHostController) {
            TestMenu.DoTestMenu(navController)
        }

        @Composable
        fun StartStop(navController: NavHostController) {
            StartStopRotation.StartStopExample(navController = navController)
        }

        @Composable
        fun PlayingWith(navController: NavHostController) {
            PlayingWithAnimationSpec.DoPlayingWithAnimationSpec(navController = navController)
        }

        @Composable
        fun Transitions(navController: NavHostController) {
            TestTransitions.DoTestTransitions(navController = navController)
        }

        @Composable
        fun ConstrainedBox(navController: NavHostController) {
            TestTransitions.TestBoxWithConstraints(navController = navController)
        }

        @RequiresApi(Build.VERSION_CODES.R)
        @Composable
        fun SlideShow(navController: NavHostController) {
            SlideShow.DoSlideShow(navController = navController)
        }

        @Composable
        fun Food2Fork(navController: NavHostController) {
            FoodToFork.DoFork(navController = navController)
        }

        @Composable
        fun FoodZFork(navController: NavHostController) {
            FoodToFork.DoFork(navController = navController)
        }

        @Composable
        fun TestFoo(navController: NavHostController) {
            println("Foooooo???????")
        }

        @Composable
        fun TestHiltX(navController: NavHostController) {
            val testingHilt = TestingHilt()
            testingHilt.DoTestHilt(navController = navController)
        }

    }


}