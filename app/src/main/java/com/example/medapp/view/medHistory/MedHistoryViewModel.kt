package com.example.medapp.view.medHistory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medapp.data.models.HistoryResponse
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.repository.MedHistoryRepository
import com.example.medapp.utils.ApiResponse
import com.example.medapp.view.baseRequest.BaseRequest
import com.example.medapp.view.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MedHistoryViewModel @Inject constructor(
    private val baseRequest: BaseRequest,
    private val medHistoryRepository: MedHistoryRepository
) : ViewModel() {

    private val _medHistory =
        MutableStateFlow<ApiResponse<ResponseBody<List<HistoryResponse>>>>(ApiResponse.Loading)

    val medHistory = _medHistory.asStateFlow()


    private val _coroutinesErrorHandlerLiveData = MutableLiveData<String>()

    private val coroutinesErrorHandler = object : CoroutinesErrorHandler {
        override fun onError(message: String) {
            _coroutinesErrorHandlerLiveData.value = message
        }
    }

    fun getMedHistory(){
        baseRequest(
            _medHistory,
            coroutinesErrorHandler,
            viewModelScope
        ){
            medHistoryRepository.getMedHistory()
        }
    }

}