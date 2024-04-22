package com.example.medapp.view.registration

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.UserResponse
import com.example.medapp.data.models.auth.AuthResponse
import com.example.medapp.data.models.auth.RegistrationRequest
import com.example.medapp.data.repository.RegistrationRepository
import com.example.medapp.utils.ApiResponse
import com.example.medapp.view.baseRequest.BaseRequest
import com.example.medapp.view.baseRequest.CoroutinesErrorHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val repository: RegistrationRepository,
    private val baseRequest: BaseRequest
) : ViewModel() {

    private var email = ""
    private var password = ""
    private var role = ""

    private val _authResponse =
        MutableStateFlow<ApiResponse<ResponseBody<AuthResponse>>>(ApiResponse.Loading)

    val authResponse = _authResponse.asStateFlow()


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

    fun continueReg(email: String, password: String, role: String) {
        this.email = email
        this.password = password
        this.role = role
    }

    fun regist(
        firstname: String,
        lastname: String,
        passport: String
    ) {
        baseRequest(_authResponse, coroutinesErrorHandler, viewModelScope) {
            val request = RegistrationRequest(
                email,
                password,
                password,
                role,
                firstname,
                lastname,
                passport
            )
            repository.regist(request)
        }
    }


    fun getUser(){
        baseRequest(_user, coroutinesErrorHandler, viewModelScope){
            repository.getUser()
        }
    }

}