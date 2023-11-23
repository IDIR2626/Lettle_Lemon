package com.example.lettlelemon

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true)
fun AppScreen(){
    val navController = rememberNavController()

    val destinationsList = listOf (Home, Menu, Location)
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(1)
    }

    Scaffold(
        topBar = {
            TopAppBar()
        },

        bottomBar = {
            NavigationBar() {
                destinationsList.forEach { screen ->
                    NavigationBarItem(

                        icon = {
                            Icon(
                                painter = painterResource(id = screen.icon),
                                contentDescription = "icon")
                               },
                        label = { Text(text = screen.title)},
                        selected = true,
                        onClick = {
                            selectedIndex = destinationsList.indexOf(screen)
                            navController.navigate(destinationsList[selectedIndex].route) {
                                popUpTo(Home.route)
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ){
            Navigation(navController)
        }
    }
}
