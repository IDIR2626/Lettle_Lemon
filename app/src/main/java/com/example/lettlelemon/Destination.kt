package com.example.lettlelemon

interface Destination{
    val route :String
    val icon: Int
    val title : String
}


object Home:Destination{
    override val route = "Home"
    override val icon = R.drawable.ic_home
    override val title = "Home"
}

object Menu: Destination{
    override val route = "Menu"
    override val icon = R.drawable.ic_menu
    override val title = "Menu"
}

object Location : Destination{
    override val route = "Location"
    override val icon = R.drawable.ic_location
    override val title = "Location"
}


