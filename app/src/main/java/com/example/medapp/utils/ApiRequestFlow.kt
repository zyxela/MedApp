package com.example.medapp.utils

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withTimeoutOrNull
import retrofit2.Response
import javax.inject.Inject

class ApiRequestFlow @Inject constructor() {
    operator fun <T> invoke(call: suspend () -> Response<T>): Flow<ApiResponse<T>> = flow {
        emit(ApiResponse.Loading)

        withTimeoutOrNull(20000L) {
            val response = call()

            try {
                if (response.isSuccessful) {
                    response.body()?.let { data ->
                        emit(ApiResponse.Success(data))
                    }
                } else {
                    response.errorBody()?.let { error ->
                        error.close()
                        val parsedError = response.message()
                        emit(
                            ApiResponse.Failure(
                                parsedError
                            )
                        )
                    }
                }
            } catch (e: Exception) {
                emit(ApiResponse.Failure(e.message ?: e.toString()))
            }
        } ?: emit(ApiResponse.Failure("Timeout! Please try again."))
    }.flowOn(Dispatchers.IO)
}