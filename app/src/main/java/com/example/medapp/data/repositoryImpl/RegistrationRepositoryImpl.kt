package com.example.medapp.data.repositoryImpl

import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.UserResponse
import com.example.medapp.data.models.auth.AuthResponse
import com.example.medapp.data.models.auth.RegistrationRequest
import com.example.medapp.data.network.AuthService
import com.example.medapp.data.network.UserService
import com.example.medapp.data.repository.RegistrationRepository
import com.example.medapp.data.source.UserDataSource
import com.example.medapp.utils.ApiRequestFlow
import com.example.medapp.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RegistrationRepositoryImpl @Inject constructor(
    private val authService: AuthService,
    private val apiRequestFlow: ApiRequestFlow,
    private val userService: UserService,
    private val userDataSource: UserDataSource
) : RegistrationRepository {
    override fun regist(registrationRequest: RegistrationRequest): Flow<ApiResponse<ResponseBody<AuthResponse>>> =
        apiRequestFlow {
            authService.registration(registrationRequest)
        }

    override fun getUser(): Flow<ApiResponse<ResponseBody<UserResponse>>> = apiRequestFlow {
        userService.getUser(userDataSource.getUserId())
    }
}