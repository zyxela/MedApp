package com.example.medapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medapp.view.ActionProfile
import com.example.medapp.view.DeviceScreen
import com.example.medapp.view.Doctors
import com.example.medapp.view.Login
import com.example.medapp.view.MedicalHistory
import com.example.medapp.view.PersonalData
import com.example.medapp.view.Profile
import com.example.medapp.view.Registration
import com.example.medapp.view.Visits

@Composable
fun NavGraph(navController: NavHostController, startDestination: String = Screen.ActionProfile.route) {
    NavHost(navController = navController, startDestination = startDestination) {

        //AUTH
        composable(Screen.Login.route) {
            Login()
        }
        composable(Screen.Registration.route) {
            Registration()
        }
        composable(Screen.PersonalData.route) {
            PersonalData()
        }


        //PATIENT
        composable(Screen.UsersProfile.route) {
            Profile()
        }
        composable(Screen.MedHistory.route) {
            MedicalHistory()
        }
        composable(Screen.Doctors.route) {
            Doctors()
        }

        //DOCTOR
        composable(Screen.Visits.route) {
            Visits(navController)
        }

        composable(Screen.ActionProfile.route){
            ActionProfile(navController)
        }

        composable(Screen.Devices.route){
            DeviceScreen()
        }

    }
}