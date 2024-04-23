package com.example.medapp.data.network

import com.example.medapp.data.models.HistoryResponse
import com.example.medapp.data.models.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MedHistoryService {

    @GET("patient/{userId}/medical")
    suspend fun getMedHistory(@Path("userId") userId: Int): Response<ResponseBody<List<HistoryResponse>>>
}