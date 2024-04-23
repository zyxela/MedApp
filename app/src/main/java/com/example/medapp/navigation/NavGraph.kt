package com.example.medapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.medapp.utils.sharedViewModel
import com.example.medapp.view.ActionProfile
import com.example.medapp.view.Device.DeviceScreen
import com.example.medapp.view.Doctors
import com.example.medapp.view.doctorProfile.DoctorsProfile
import com.example.medapp.view.medHistory.MedicalHistory
import com.example.medapp.view.userProfile.Profile
import com.example.medapp.view.visits.Visits
import com.example.medapp.view.login.Login
import com.example.medapp.view.registration.PersonalData
import com.example.medapp.view.registration.Registration
import com.example.medapp.view.registration.RegistrationViewModel

@Composable
fun NavGraph(navController: NavHostController, startDestination: String = Screen.Login.route) {
    NavHost(navController = navController, startDestination = startDestination) {

        //AUTH
        composable(Screen.Login.route) {
            Login(navController)
        }
        navigation(startDestination = Screen.Registration.route, "COMMON"){
            composable(Screen.Registration.route) { entry ->
                val viewModel =
                    entry.sharedViewModel<RegistrationViewModel>(navController = navController)


                Registration(navController, viewModel)
            }
            composable(Screen.PersonalData.route) { entry ->
                val viewModel =
                    entry.sharedViewModel<RegistrationViewModel>(navController = navController)

                PersonalData(navController, viewModel)
            }
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

        composable(Screen.ActionProfile.route) {
            ActionProfile(navController)
        }

        composable(Screen.Devices.route) {
            DeviceScreen()
        }

        composable(Screen.DoctorsProfile.route) {
            DoctorsProfile()
        }

    }
}