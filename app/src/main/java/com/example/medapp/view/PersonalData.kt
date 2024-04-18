package com.example.medapp.view

import androidx.compose.foundation.Image
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medapp.R
import com.example.medapp.ui.components.buttons.ActionButton
import com.example.medapp.ui.components.text.InfoText
import com.example.medapp.ui.components.text.LinkText
import com.example.medapp.ui.components.textfields.RegistrationTextField
import com.example.medapp.ui.components.checkboxes.SquareCheckbox
import com.example.medapp.ui.components.text.TitleText
import com.example.medapp.ui.theme.Lime800
import com.example.medapp.ui.theme.LinkOrange

@Composable
fun PersonalData() {

    var passport by remember {
        mutableStateOf("")
    }

    var firstname by remember {
        mutableStateOf("")
    }

    var lastname by remember {
        mutableStateOf("")
    }

    var isAccepted by remember {
        mutableStateOf(false)
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.personal_data_bg),
                    contentScale = ContentScale.FillWidth,
                    contentDescription = ""
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(35.dp, 70.dp, 35.dp, 50.dp)
            ) {
                TitleText(
                    text = "Personal data",
                    textColor = Lime800,
                    shadowColor = Color.LightGray
                )
                InfoText(
                    text = "We need some of your personal data to allow to use this app",
                    color = Lime800,
                    20
                )

                Column {
                    RegistrationTextField(
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp),
                        hint = "Passport (XX9999999)",
                        value = passport
                    ) {
                        passport = it
                    }

                    RegistrationTextField(
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp),
                        hint = "Firstname",
                        value = firstname
                    ) {
                        firstname = it
                    }

                    RegistrationTextField(
                        modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp),
                        hint = "Lastname",
                        value = lastname
                    ) {
                        lastname = it
                    }
                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    SquareCheckbox(
                        label = "I have read and agreed to the",
                        isChecked = isAccepted
                    ) {
                        isAccepted = !isAccepted
                    }
                    Row(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 20.dp)) {
                        LinkText(text = "Terms of Use ", color = LinkOrange) {

                        }
                        InfoText(text = " and ")
                        LinkText(text = "Terms of Use", color = LinkOrange) {

                        }
                    }

                    ActionButton(width = 130, text = "Continue") {

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

@Preview(showBackground = true)
@Composable
fun PersonalDataPreview() {
    PersonalData()
}