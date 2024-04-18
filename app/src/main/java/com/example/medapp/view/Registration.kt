package com.example.medapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medapp.R
import com.example.medapp.ui.components.buttons.ActionButton
import com.example.medapp.ui.components.checkboxes.CircleCheckBox
import com.example.medapp.ui.components.text.InfoText
import com.example.medapp.ui.components.text.LinkText
import com.example.medapp.ui.components.textfields.RegistrationTextField
import com.example.medapp.ui.components.text.TitleText
import com.example.medapp.ui.theme.Lime800

@Composable
fun Registration() {
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var confirmPassword by remember {
        mutableStateOf("")
    }

    var isDoctor by remember {
        mutableStateOf(true)
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Box {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillWidth,
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(35.dp, 70.dp, 35.dp, 50.dp)
            ) {
                TitleText(text = "Registration", textColor = Lime800, shadowColor = Color.Gray)

                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    RegistrationTextField(hint = "Email", value = email) {
                        email = it
                    }
                    Column(
                        modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        TitleText(
                            text = "Your Role",
                            fontSize = 28f,
                            textColor = Lime800,
                            shadowColor = Color.Gray
                        )

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            CircleCheckBox(label = "doctor", isChecked = isDoctor) {
                                isDoctor = true
                            }
                            CircleCheckBox(label = "patient", isChecked = !isDoctor) {
                                isDoctor = false
                            }
                        }

                    }
                    Column(
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 0.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {


                        RegistrationTextField(
                            modifier = Modifier.padding(0.dp, 5.dp),
                            hint = "Password",
                            isPassword = true,
                            value = password
                        ) {
                            password = it
                        }
                        RegistrationTextField(
                            modifier = Modifier.padding(0.dp, 5.dp),
                            hint = "Confirm Password",
                            isPassword = true,
                            value = confirmPassword
                        ) {
                            confirmPassword = it
                        }
                        Column(
                            modifier = Modifier.padding(0.dp, 20.dp, 0.dp, 0.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            ActionButton(150, text = "Continue") {

                            }

                            Row {
                                InfoText(text = "Already have an account? ")
                                LinkText(text = "Sign in") {

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
fun RegistrationPreview() {
    Registration()
}