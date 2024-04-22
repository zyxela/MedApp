package com.example.medapp.data.repositoryImpl

import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.UserResponse
import com.example.medapp.data.network.UserService
import com.example.medapp.data.source.UserDataSource
import com.example.medapp.utils.ApiRequestFlow
import com.example.medapp.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class AuthCommon @Inject constructor(
    private val userService: UserService,
    private val userDataSource: UserDataSource,
    private val apiRequestFlow: ApiRequestFlow
) {

    fun getUser(): Flow<ApiResponse<ResponseBody<UserResponse>>> = apiRequestFlow {
        val userId = userDataSource.getUserId()
        userService.getUser(userId)
    }
}

