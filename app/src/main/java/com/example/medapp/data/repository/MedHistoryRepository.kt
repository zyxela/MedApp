package com.example.medapp.data.repository

import com.example.medapp.data.models.HistoryResponse
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.utils.ApiResponse
import kotlinx.coroutines.flow.Flow


interface MedHistoryRepository {
    fun getMedHistory(): Flow<ApiResponse<ResponseBody<List<HistoryResponse>>>>
}