package com.example.cotuit.network

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

class NetworkMonitor {


    companion object{


        @Composable
        fun ShowNetworkAvailability(isNetworkAvailable: Boolean){

            val isInternetAvailableModifier = Modifier
                .background(Color(0xFF52B455))
                .fillMaxWidth()

            val isInternetNotAvailableModifier = Modifier
                .background(Color(0xFFF44336))
                .fillMaxWidth()

            var avail by remember { mutableStateOf("YES") }

            var mod by remember {
                mutableStateOf(isInternetAvailableModifier)
            }

            if(!isNetworkAvailable){
                avail = "NO"
                mod = isInternetNotAvailableModifier
            }else{
                avail = "YES"
                mod = isInternetAvailableModifier
            }


            Text("Network Available? $avail", color = Color.White, modifier = mod)

        }


    }


}