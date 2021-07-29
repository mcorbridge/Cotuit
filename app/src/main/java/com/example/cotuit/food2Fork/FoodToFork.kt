package com.example.cotuit.food2Fork

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.cotuit.interactors.DoesNetworkHaveInternet
import com.example.cotuit.interactors.FooObject
import com.example.cotuit.menu.NavIcon

class FoodToFork {


    companion object{

        @Composable
        fun DoFork(navController: NavHostController){

            // basically a java static class
            FooObject.DoFoo()


            Column{

                // allow navigation back to Main Menu
                NavIcon.MenuIcon(navController = navController)

                Text("Features", fontWeight = FontWeight.ExtraBold, fontSize = 32.sp)

                Text("1. Kotlin\n" +
                        "2. MVVM\n" +
                        "3. Compose navigation (one activity, zero fragments)\n" +
                        "4. Retrieve Network Data from API (REST API)\n" +
                        "5. Database caching\n" +
                        "6. Monitoring Network Connectivity\n" +
                        "7. Use cases\n" +
                        "8. Datastore (New Shared Preferences)\n" +
                        "9. Unit Tests\n" +
                        "10. MockWebServer (Okhttp)\n" +
                        "11. Kotlin Flow\n" +
                        "12. Dependency management with Kotlin kts")
            }


        }

        fun testForInternet(){
            //DoesNetworkHaveInternet.execute()
        }

    }


}