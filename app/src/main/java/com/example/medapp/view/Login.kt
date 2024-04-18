package com.example.medapp.view

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medapp.ui.components.buttons.ActionButton
import com.example.medapp.ui.components.text.InfoText
import com.example.medapp.ui.components.text.LinkText
import com.example.medapp.ui.components.textfields.LoginTextField
import com.example.medapp.ui.components.text.TitleText
import com.example.medapp.ui.theme.LoginGradient

@Composable
fun Login() {

    var login by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
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

                            }
                            Row {
                                InfoText(text = "Don’t have an account? ", Color.White)
                                LinkText(text = "Sign up") {

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
    Login()
}