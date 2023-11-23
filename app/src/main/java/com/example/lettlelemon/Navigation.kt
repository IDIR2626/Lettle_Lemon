package com.example.lettlelemon

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController){
    //val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home.route){

        composable(Home.route){
            HomeScreen(navController)
        }
        composable(Menu.route){
            MenuListScreen(navController)
        }
        composable(Location.route){
            LocationScreen(navController)
        }

    }
}