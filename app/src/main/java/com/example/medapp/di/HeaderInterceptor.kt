package com.example.medapp.di

import com.example.medapp.data.source.TokenDataSource
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class HeaderInterceptor @Inject constructor(
    private val tokenDataSource: TokenDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        requestBuilder.header("x-api-key", TokenDataSource.X_API_KEY)

        val authToken = tokenDataSource.getJWT()
        val authHeaderValue = "Bearer $authToken"
        requestBuilder.header("Authorization", authHeaderValue)

        val request = requestBuilder.build()
        return chain.proceed(request)
    }
}