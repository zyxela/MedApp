package com.example.medapp.data.repository

import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.UserResponse
import com.example.medapp.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(): Flow<ApiResponse<ResponseBody<UserResponse>>>
}