package com.example.medapp.data.repositoryImpl

import com.example.medapp.data.models.DoctorVisitResponse
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.network.VisitsService
import com.example.medapp.data.repository.VisitsRepository
import com.example.medapp.data.source.UserDataSource
import com.example.medapp.utils.ApiRequestFlow
import com.example.medapp.utils.ApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class VisitsRepositoryImpl @Inject constructor(
    private val apiRequestFlow: ApiRequestFlow,
    private val visitsService: VisitsService,
    private val userDataSource: UserDataSource
) : VisitsRepository {
    override fun getVisits(): Flow<ApiResponse<ResponseBody<List<DoctorVisitResponse>>>> =
        apiRequestFlow {
            val id = userDataSource.getUserId()
            visitsService.getVisits(id)
        }
}