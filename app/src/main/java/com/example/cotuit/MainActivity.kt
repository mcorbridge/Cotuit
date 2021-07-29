package com.example.cotuit

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.rememberNavController
import com.example.cotuit.menu.AppNav
import com.example.cotuit.ui.theme.CotuitTheme
import com.example.cotuit.util.ConnectionLiveData
import com.example.cotuit.util.ConnectivityManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var connectivityManager: ConnectivityManager

    override fun onStart() {
        super.onStart()
        connectivityManager.registerConnectionObserver(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        connectivityManager.unregisterConnectionObserver(this)
    }


    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {
            CotuitTheme {

                Surface(color = MaterialTheme.colors.background) {

                    val navController = rememberNavController()
                    val isNetworkAvailable = connectivityManager.isNetworkAvailable.value

                    println(" ///////////////////// isNetworkAvailable? $isNetworkAvailable //////////////////////")

                    // opens/runs AppMenu.kt
                    AppNav.NavigationInit(navController)

                }
            }
        }
    }


}




