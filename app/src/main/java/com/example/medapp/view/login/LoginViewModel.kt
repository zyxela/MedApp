package com.example.medapp.view.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.UserResponse
import com.example.medapp.data.models.auth.AuthResponse
import com.example.medapp.data.repository.LoginRepository
import com.example.medapp.utils.ApiResponse
import com.example.medapp.view.baseRequest.BaseRequest
import com.example.medapp.view.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository,
    private val baseRequest: BaseRequest
) :
    ViewModel() {

    private val _result =
        MutableStateFlow<ApiResponse<ResponseBody<AuthResponse>>>(ApiResponse.Loading)
    val result: StateFlow<ApiResponse<ResponseBody<AuthResponse>>> = _result

    private val _user =
        MutableStateFlow<ApiResponse<ResponseBody<UserResponse>>>(ApiResponse.Loading)
    val user: StateFlow<ApiResponse<ResponseBody<UserResponse>>>
        get() = _user

    private val _coroutinesErrorHandlerLiveData = MutableLiveData<String>()

    private val coroutinesErrorHandler = object : CoroutinesErrorHandler {
        override fun onError(message: String) {
            _coroutinesErrorHandlerLiveData.value = message
        }
    }

    fun login(email: String, password: String) =
        baseRequest(_result, coroutinesErrorHandler, viewModelScope) {
            loginRepository.login(email, password)
        }

    fun getUser() = baseRequest(
        _user,
        coroutinesErrorHandler,
        viewModelScope
    ) {
        loginRepository.getUser()
    }

}