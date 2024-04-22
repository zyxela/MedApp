package com.example.medapp.data.models.auth

data class AuthResponse(
    val jwt: String,
    val user_id: Int
)
