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

            val networkYES = Modifier
                .background(Color(0xFF52B455))
                .fillMaxWidth()

            val networkNO = Modifier
                .background(Color(0xFFF44336))
                .fillMaxWidth()

            var avail by remember { mutableStateOf("YES") }

            var mod by remember {
                mutableStateOf(networkYES)
            }

            if(!isNetworkAvailable){
                avail = "NO"
                mod = networkNO
            }else{
                avail = "YES"
                mod = networkYES
            }

            Text("Network Available? $avail", color = Color.White, modifier = mod)

        }
    }
}