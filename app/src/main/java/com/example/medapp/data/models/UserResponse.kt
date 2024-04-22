package com.example.medapp.data.models

data class UserResponse(
    val doctor: Doctor,
    val email: String,
    val firstname: String,
    val id: Int,
    val lastname: String,
    val passport: String,
    val password: String,
    val photo: String,
    val reg_date: String,
    val role: String
)