package com.example.medapp.data.network



import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.auth.AuthRequest
import com.example.medapp.data.models.auth.AuthResponse
import com.example.medapp.data.models.auth.RegistrationRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {

    @POST("user/auth")
    suspend fun authorization(@Body authRequest: AuthRequest): Response<ResponseBody<AuthResponse>>

    @POST("user/reg")
    suspend fun registration(@Body regRequest: RegistrationRequest): Response<ResponseBody<AuthResponse>>
}