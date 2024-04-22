package com.example.medapp.data.network

import com.example.medapp.data.models.DoctorVisitResponse
import com.example.medapp.data.models.ResponseBody
import retrofit2.Response
import retrofit2.http.POST
import retrofit2.http.Path

interface VisitsService {
    @POST("doctor/{doctorId}/visit")
    fun getVisits(@Path("userId") userId: Int): Response<ResponseBody<List<DoctorVisitResponse>>>
}