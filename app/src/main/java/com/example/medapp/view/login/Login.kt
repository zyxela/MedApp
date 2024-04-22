package com.example.medapp.view.login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.UserResponse
import com.example.medapp.data.models.auth.AuthResponse
import com.example.medapp.data.source.TokenDataSource
import com.example.medapp.navigation.Screen
import com.example.medapp.ui.components.buttons.ActionButton
import com.example.medapp.ui.components.text.InfoText
import com.example.medapp.ui.components.text.LinkText
import com.example.medapp.ui.components.text.TitleText
import com.example.medapp.ui.components.textfields.LoginTextField
import com.example.medapp.ui.theme.LoginGradient
import com.example.medapp.utils.ApiResponse

@Composable
fun Login(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    val context = LocalContext.current

    var login by remember {
        mutableStateOf("john.doe@example.com")
    }

    var password by remember {
        mutableStateOf("password1")
    }

    val result by viewModel.result.collectAsState()


    when (result) {
        is ApiResponse.Success -> {
            TokenDataSource(context.getSharedPreferences("prefs_key", Context.MODE_PRIVATE)).setJWT(
                (result as ApiResponse.Success<ResponseBody<AuthResponse>>).data.data.jwt
            )
            viewModel.getUser()

        }

        is ApiResponse.Failure -> {
            Toast.makeText(
                context,
                (result as ApiResponse.Failure).errorMessage.orEmpty(),
                Toast.LENGTH_LONG
            ).show()
        }

        ApiResponse.Loading -> {

        }
    }

    val user by viewModel.user.collectAsState()


    when (user) {
        is ApiResponse.Failure -> {
            Toast.makeText(
                context,
                (user as ApiResponse.Failure).errorMessage.toString(),
                Toast.LENGTH_LONG
            ).show()
        }

        is ApiResponse.Success<ResponseBody<UserResponse>> -> {
            //val res = user.data.data
            Toast.makeText(
                context,
                (user as ApiResponse.Success<ResponseBody<UserResponse>>).data.data.email.toString(),
                Toast.LENGTH_LONG
            ).show()
        }

        is ApiResponse.Loading -> {

        }


    }

    Surface(
        modifier = Modifier

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(LoginGradient)),

            ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(35.dp, 260.dp, 35.dp, 50.dp)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(horizontalAlignment = Alignment.Start) {
                            TitleText(text = "Login")
                            LoginTextField("Email", login) {
                                login = it
                            }
                            LoginTextField("Password", password, true) {
                                password = it
                            }
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            ActionButton(
                                120,
                                text = " Enter "
                            ) {
                                viewModel.login(login, password)
                            }
                            Row {
                                InfoText(text = "Don’t have an account? ", Color.White)
                                LinkText(text = "Sign up") {
                                    navController.navigate(Screen.Registration.route)
                                }
                            }
                        }

                    }

                }

            }

        }

    }


}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    Login(rememberNavController())
}