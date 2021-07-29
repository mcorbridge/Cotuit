package com.example.cotuit.interactors

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException
import java.net.InetSocketAddress
import javax.net.SocketFactory
import androidx.compose.runtime.*

const val TAG = "C-Manager"

/**
 * Send a ping to googles primary DNS.
 * If successful, that means we have internet.
 * DNS - 53
 * DNS is referred to as 'Domain Name System'. It operates on the port 53 of TCP
 */
object DoesNetworkHaveInternet {

    // Make sure to execute this on a background thread.
    fun execute(socketFactory: SocketFactory): Boolean {
        return try{
            Log.d(TAG, ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> PINGING google.")
            val socket = socketFactory.createSocket() ?: throw IOException("Socket is null.")
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            Log.d(TAG, "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! PING success.")
            true
        }catch (e: IOException){
            Log.e(TAG, "No internet connection. ${e}")
            false
        }
    }
}