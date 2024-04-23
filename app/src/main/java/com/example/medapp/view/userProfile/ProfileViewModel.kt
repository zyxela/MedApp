package com.example.medapp.view.userProfile

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.UserResponse
import com.example.medapp.data.repository.UserRepository
import com.example.medapp.utils.ApiResponse
import com.example.medapp.view.baseRequest.BaseRequest
import com.example.medapp.view.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val baseRequest: BaseRequest,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _userInfo =
        MutableStateFlow<ApiResponse<ResponseBody<UserResponse>>>(ApiResponse.Loading)
    val userInfo = _userInfo.asStateFlow()

    private val _coroutinesErrorHandlerLiveData = MutableLiveData<String>()

    private val coroutinesErrorHandler = object : CoroutinesErrorHandler {
        override fun onError(message: String) {
            _coroutinesErrorHandlerLiveData.value = message
        }
    }

    fun getDoctorInfo() {
        baseRequest(
            _userInfo,
            coroutinesErrorHandler,
            viewModelScope
        ) {
            userRepository.getUser()
        }
    }
}