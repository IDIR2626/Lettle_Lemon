@file:Suppress("DEPRECATION")

package com.example.lettlelemon

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun Navigation(navController: NavHostController){
    //val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Home.route){

        composable(route = Home.route){
            HomeScreen(navController)
        }

        composable(route = Location.route){
            LocationScreen(navController)
        }

        composable(route = Menu.route){
            MenuListScreen(navController)
        }
        composable(
            route = "dish_details/{name}/{description}/{image}",
            arguments = listOf(
                navArgument(name = "name"){
                    type = NavType.StringType
                },
                navArgument(name = "description"){
                    type = NavType.StringType
                },
                navArgument(name = "image"){
                    type = NavType.IntType
                }
            )
        ){
            val name = it.arguments?.getString("name")
            val description = it.arguments?.getString("description")
            val image = it.arguments?.getInt("image")
            if (image != null) {
                DishDetails(navController, name.toString(), description.toString(), image.toInt())
            }
        }

    }
}