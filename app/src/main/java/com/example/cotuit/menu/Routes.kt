package com.example.cotuit.menu

enum class Routes(val route:String, val access:String) {

    /**
     * By storing the routes as an Enum value, it makes it easier to build the navigation routes
     * based on value rather than a String, which can be misspelled or duplicated by accident
     *
     * the 'route' is the string used by the NavHostController to open a new screen with the
     * composable
     *
     * the 'access' is intended to provide user access security, if this ever becomes a thing for this app
     *
     * HEY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     * Are you trying to find out where this goes next?  <---------------------------------
     *
     * Open 'AppNav' and look for the Key stored here, for example 'MOVING_SQUARE'
     * HEY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     */

    MENU("menu", "admin"),
    WHO_BUILT("whoBuilt", "everyone"),
    SWITCHING_SQUARES("switchingSquares", "admin"),
    ROTATING_SQUARE("rotatingSquare", "admin"),
    MOVING_SQUARE("movingSquare", "admin"),
    TEST_MENU("testMenu", "admin"),
    START_STOP("startStop", "admin"),
    PLAYING_WITH("playingWith", "admin"),
    TRANSITIONS("transitions", "admin"),
    BOX_WITH_CONSTRAINTS("boxWithConstraints", "admin"),
    SLIDE_SHOW("slideShow", "admin")

}