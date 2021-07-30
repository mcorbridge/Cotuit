package com.example.cotuit.hilt

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TestInject
@Inject
constructor() {

    private var isNetworkAvailable = mutableStateOf(false)

    @Composable
    fun ShowNetworkAvailability(networkAvailability: Boolean) {

        isNetworkAvailable.value = networkAvailability

        println("networkAvailability = $networkAvailability isNetworkAvailable.value = ${isNetworkAvailable.value}")

        Column {

            if (networkAvailability) {
                Text("Network IS Available", color = Color(0xFF009688))
            } else {
                Text("Network IS NOT Available", color = Color(0xFFF44336))
            }
        }


    }


}
