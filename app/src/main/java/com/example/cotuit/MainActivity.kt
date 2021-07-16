package com.example.cotuit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.example.cotuit.menu.AppNav
import com.example.cotuit.ui.theme.CotuitTheme

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            CotuitTheme {

                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()

                    AppNav.NavigationInit(navController)

                }
            }
        }
    }
}




