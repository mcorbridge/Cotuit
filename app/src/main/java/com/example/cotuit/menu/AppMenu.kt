package com.example.cotuit.menu

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

class AppMenu(private val navController: NavHostController) {

    @Composable
    fun MenuButtons() {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0x25454564))
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            DisplayCard(CardDescription.CARD_HOW_TO.title, CardDescription.CARD_HOW_TO.description, Routes.WHO_BUILT.route)

            DisplayCard(CardDescription.CARD_ONE.title, CardDescription.CARD_ONE.description, Routes.TEST_MENU.route)

            DisplayCard(CardDescription.CARD_TWO.title, CardDescription.CARD_TWO.description, Routes.MOVING_SQUARE.route)

            DisplayCard(CardDescription.CARD_THREE.title, CardDescription.CARD_THREE.description, Routes.SWITCHING_SQUARES.route)

            DisplayCard(CardDescription.CARD_FOUR.title, CardDescription.CARD_FOUR.description, Routes.ROTATING_SQUARE.route)

            DisplayCard(CardDescription.CARD_FIVE.title, CardDescription.CARD_FIVE.description,  Routes.START_STOP.route)

            DisplayCard(CardDescription.CARD_SIX.title, CardDescription.CARD_SIX.description,  Routes.PLAYING_WITH.route)

            DisplayCard(CardDescription.CARD_SEVEN.title, CardDescription.CARD_SEVEN.description,  Routes.TRANSITIONS.route)

            DisplayCard(CardDescription.CARD_EIGHT.title, CardDescription.CARD_EIGHT.description,  Routes.BOX_WITH_CONSTRAINTS.route)

            DisplayCard(CardDescription.CARD_NINE.title, CardDescription.CARD_NINE.description,  Routes.SLIDE_SHOW.route)

            DisplayCard(CardDescription.CARD_TEN.title, CardDescription.CARD_TEN.description,  Routes.FOOD_2_FORK.route)

        }
    }

    @Composable
    fun DisplayCard(title:String, detail:String, navRoute: String){
        Card(shape = RoundedCornerShape(10.dp),
            backgroundColor = Color(0xFFEBD592),
            contentColor = Color(0xFF081C88),
            border = BorderStroke(2.dp, Color(0xFFAFB2BD)),
            elevation = 16.dp,
            modifier = Modifier
                .clickable { navController.navigate(navRoute) }
                .fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = title, fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp))
                Text(text = detail,modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp))
            }
        }
    }

} // end class

enum class CardDescription(val title:String, val description: String) {

    CARD_HOW_TO(
        "How To...",
        "... add a new Item. \n(1) Create a new example (a @Composable)\n(2) In 'NavRoutes' create a @Composable fn " +
            "that calls your new example.\n(3) Create a descriptive reference in the 'Routes' enum\n(4) In 'AppNav', create a route to the new " +
            "composable using route created in 'Routes', that points to the @Composable in 'NavRoutes\n(5) Create a new Card in 'AppMenu " +
            "that displays a title/description, and the route that is stored in 'Routes'."),

    CARD_ONE(
        "Example One - tbd",
        "In which an ICON is used to navigate back to the MAIN MENU."),

    CARD_TWO(
        "Example Two - Repeatable",
        "Animation example that shows AnimationSpec 'Repeatable' where the animation " +
                "is started auto*magically* via a Kotlin Coroutine."),

    CARD_THREE(
        "Example Three - Multiple Moving Squares",
        "Moving Squares - in which colored squares magically move diagonally, vertically, and horizontally" +
                " to demonstrate the simplest Compose animation features."),

    CARD_FOUR(
        "Example Four - Infinite Rotation",
        "An example of an AnimationSpec using infinite rotation, in which a square rotates 360 degrees " +
                "infinitely, and increments a counter each full rotation."),

    CARD_FIVE(
        "Example Five - Start & Stop Infinite Rotation",
        "Similar to Example 3, but the square will stop rotating when clicked on " +
                "and restart where it stopped when clicked again.  A Text field displays the number of rotations and the " +
                "number of click events."),

    CARD_SIX(
        "Example Six - Testing the Animation API",
        "Playing with Animations Specs:\n" + "Spring\n" + "Tween\n" + "Keyframes\n" + "Snap"),

    CARD_SEVEN(
        "Example Seven - Transitions",
        "TODO"),

    CARD_EIGHT(
        "Example Eight - Box With Constraints",
        "In order to know the constraints coming from the parent and design the layout accordingly, " +
                "you can use a BoxWithConstraints. The measurement constraints " +
                "can be found in the scope of the content lambda. You can use these measurement " +
                "constraints to compose different layouts for different screen configurations:"),

    CARD_NINE(
        "Example Nine - Slide Show",
        "A 'roll your own' slide show component that works great, and will have to do until the " +
                "geniuses at Google or Accompanist (same thing?) come up with one."),

    CARD_TEN(
        "Example Ten - Food2Fork",
        "Kotlin\n" +
                "MVVM\n" +
                "Compose navigation (one activity, zero fragments)\n" +
                "Retrieve Network Data from API (REST API)\n" +
                "Database caching\n" +
                "Monitoring Network Connectivity\n" +
                "Use cases\n" +
                "Datastore (New Shared Preferences)\n" +
                "Unit Tests\n" +
                "MockWebServer (Okhttp)\n" +
                "Kotlin Flow\n" +
                "Dependency management with Kotlin kts"),


} // end class