package com.example.medapp.data.repositoryImpl

import com.example.medapp.data.models.HistoryResponse
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.network.MedHistoryService
import com.example.medapp.data.repository.MedHistoryRepository
import com.example.medapp.data.source.UserDataSource
import com.example.medapp.utils.ApiRequestFlow
import com.example.medapp.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MedHistoryRepositoryImpl @Inject constructor(
    private val apiRequestFlow: ApiRequestFlow,
    private val medHistoryService: MedHistoryService,
    private val userDataSource: UserDataSource
) : MedHistoryRepository {
    override fun getMedHistory(): Flow<ApiResponse<ResponseBody<List<HistoryResponse>>>> =
        apiRequestFlow {
            medHistoryService.getMedHistory(userDataSource.getUserId())
        }
}