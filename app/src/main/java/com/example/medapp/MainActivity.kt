package com.example.medapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.rememberNavController
import com.example.medapp.navigation.NavGraph
import com.example.medapp.ui.components.navigation.DoctorsBottomNavigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val navController = rememberNavController()

            Scaffold(bottomBar = {
                when(navController.currentDestination?.route){
                   // Screen.
                }
                DoctorsBottomNavigation(navController = navController)
            }) {
                NavGraph(navController)
            }


        }


    }


}