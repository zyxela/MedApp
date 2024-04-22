package com.example.medapp.data.network

import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface UserService {

    @GET("user/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): Response<ResponseBody<UserResponse>>
}