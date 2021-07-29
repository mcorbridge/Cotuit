package com.example.cotuit.menu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController


class NavIcon {

    companion object{
        @Composable
        fun MenuIcon(navController: NavHostController) {
            Box {
                Icon(Icons.Rounded.Menu, contentDescription = "Localized description",modifier = Modifier.clickable {
                    navController.navigate(Routes.MENU.route)
                })
            }
        }
    }



}