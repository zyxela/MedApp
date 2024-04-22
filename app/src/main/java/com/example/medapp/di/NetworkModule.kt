package com.example.medapp.di

import com.example.medapp.data.network.AuthService
import com.example.medapp.data.network.UserService
import com.example.medapp.data.network.VisitsService
import com.example.medapp.data.source.TokenDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    companion object {
        private const val BASE_URL = "http://bsuirsntk60120604.space/api/"
    }

    @Provides
    @Singleton
    fun getRetrofit(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
    }

    @Provides
    @Singleton
    fun getClient(
        headerInterceptor: HeaderInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(headerInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideAuthInterceptor(tokenManager: TokenDataSource): HeaderInterceptor =
        HeaderInterceptor(tokenManager)



    @Provides
    @Singleton
    fun getAuthService(retrofit: Retrofit.Builder, okHttpClient: OkHttpClient): AuthService =
        retrofit.client(okHttpClient).build().create(AuthService::class.java)

    @Provides
    @Singleton
    fun getUserService(retrofit: Builder, okHttpClient: OkHttpClient): UserService =
        retrofit.client(okHttpClient).build().create(UserService::class.java)

    @Provides
    @Singleton
    fun getVisitsService(retrofit: Builder, okHttpClient: OkHttpClient): VisitsService =
        retrofit.client(okHttpClient).build().create(VisitsService::class.java)


}