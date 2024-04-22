package com.example.medapp.data.repository

import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.UserResponse
import com.example.medapp.data.models.auth.AuthResponse
import com.example.medapp.data.models.auth.RegistrationRequest
import com.example.medapp.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface RegistrationRepository {
    fun regist(registrationRequest: RegistrationRequest): Flow<ApiResponse<ResponseBody<AuthResponse>>>
    fun getUser(): Flow<ApiResponse<ResponseBody<UserResponse>>>
}