package com.example.medapp.data.network

import com.example.medapp.data.models.DoctorVisitResponse
import com.example.medapp.data.models.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface VisitsService {
    @GET("doctor/{doctorId}/visit")
    suspend fun getVisits(@Path("doctorId") doctorId: Int): Response<ResponseBody<List<DoctorVisitResponse>>>
}