package com.example.medapp.navigation

import com.example.medapp.R

sealed class Screen(val route: String, var icon: Int? = null) {
    //AUTH
    data object Login : Screen("login")
    data object Registration : Screen("registration")
    data object PersonalData : Screen("personal_data")

    //PATIENT
    data object Doctors : Screen("doctors", R.drawable.doctor)
    data object MedHistory : Screen("med_history", R.drawable.med_history)
    data object UsersProfile : Screen("users_profile", R.drawable.prof)


    //DOCTOR

    data object Visits : Screen("visits", R.drawable.visits_icon)
    data object ActionProfile : Screen("action_profile")
    data object Devices : Screen("device")

}