package com.example.medapp.data.models.auth

data class RegistrationRequest(
    val email:String,
    val password:String,
    val password_confirm:String,
    val role:String,
    val firstname:String,
    val lastname:String,
    val passport:String,

)
