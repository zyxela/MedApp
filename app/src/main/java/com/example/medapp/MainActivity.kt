package com.example.medapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.medapp.navigation.NavGraph
import com.example.medapp.navigation.Screen
import com.example.medapp.ui.components.navigation.DoctorsBottomNavigation
import com.example.medapp.ui.components.navigation.UsersBottomNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            val currentRoute =
                navController.currentBackStackEntryAsState().value?.destination?.route



            Scaffold(bottomBar = {

                if (currentRoute in usersRoutes) {
                    UsersBottomNavigation(navController = navController)
                }
                if (currentRoute in doctorsRoutes) {
                    DoctorsBottomNavigation(navController = navController)
                }

            }) {
                NavGraph(navController)
            }


        }


    }


}


internal val usersRoutes = listOf(
    Screen.UsersProfile.route,
    Screen.MedHistory.route,
    Screen.Doctors.route
)

internal val doctorsRoutes = listOf(
    Screen.Visits.route,
    Screen.DoctorsProfile.route
)