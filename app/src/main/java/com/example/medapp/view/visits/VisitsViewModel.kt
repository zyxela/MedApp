package com.example.medapp.view.visits

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medapp.data.models.DoctorVisitResponse
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.repository.VisitsRepository
import com.example.medapp.utils.ApiResponse
import com.example.medapp.view.baseRequest.BaseRequest
import com.example.medapp.view.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class VisitsViewModel @Inject constructor(
    private val visitsRepository: VisitsRepository,
    private val baseRequest: BaseRequest
) :
    ViewModel() {
    private val _visits =
        MutableStateFlow<ApiResponse<ResponseBody<List<DoctorVisitResponse>>>>(ApiResponse.Loading)
    val visits = _visits.asStateFlow()

    private val _coroutinesErrorHandlerLiveData = MutableLiveData<String>()

    private val coroutinesErrorHandler = object : CoroutinesErrorHandler {
        override fun onError(message: String) {
            _coroutinesErrorHandlerLiveData.value = message
            println(message)
        }
    }

    fun getVisits() {
        baseRequest(
            _visits,
            coroutinesErrorHandler,
            viewModelScope
        ) {
            visitsRepository.getVisits()
        }
    }
}