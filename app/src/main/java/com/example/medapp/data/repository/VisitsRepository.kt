package com.example.medapp.data.repository

import com.example.medapp.data.models.DoctorVisitResponse
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.utils.ApiResponse
import kotlinx.coroutines.flow.Flow

interface VisitsRepository {
    fun getVisits(): Flow<ApiResponse<ResponseBody<List<DoctorVisitResponse>>>>
}