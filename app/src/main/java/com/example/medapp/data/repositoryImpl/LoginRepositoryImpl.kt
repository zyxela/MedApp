package com.example.medapp.data.repositoryImpl

import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.auth.AuthRequest
import com.example.medapp.data.models.auth.AuthResponse
import com.example.medapp.data.network.AuthService
import com.example.medapp.data.network.UserService
import com.example.medapp.data.repository.LoginRepository
import com.example.medapp.data.source.UserDataSource
import com.example.medapp.utils.ApiRequestFlow
import com.example.medapp.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val authService: AuthService,
    private val apiRequestFlow: ApiRequestFlow,
    private val userService: UserService,
    private val userDataSource: UserDataSource
) :
    LoginRepository {

    override fun login(
        email: String,
        password: String
    ): Flow<ApiResponse<ResponseBody<AuthResponse>>> =
        apiRequestFlow {
            val request = AuthRequest(email, password)
            authService.authorization(request)
        }

    override fun getUser() = apiRequestFlow {
        userService.getUser(userDataSource.getUserId())
    }

}