package com.example.medapp.view.doctorProfile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medapp.R
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.data.models.UserResponse
import com.example.medapp.ui.components.buttons.FloatingEditButton
import com.example.medapp.ui.components.text.TextRobotoBold
import com.example.medapp.ui.components.text.TextRobotoLight
import com.example.medapp.ui.theme.Grey500
import com.example.medapp.ui.theme.Lime800
import com.example.medapp.utils.ApiResponse

@Composable
fun DoctorsProfile(viewModel: DoctorProfileViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.getDoctorInfo()
    }

    val doctorInfo by viewModel.doctorInfo.collectAsState()

    var name by remember {
        mutableStateOf("")
    }

    var specialization by remember {
        mutableStateOf("")
    }

    var stage by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var schedule by remember {
        mutableStateOf("")
    }


    when (doctorInfo) {
        is ApiResponse.Success -> {
            val response = (doctorInfo as ApiResponse.Success<ResponseBody<UserResponse>>).data.data
            name = response.firstname + " " + response.lastname
            specialization = response.doctor.qualification
            stage = response.doctor.stage
            email = response.email
            schedule = response.doctor.schedule
        }

        is ApiResponse.Failure -> {
            println((doctorInfo as ApiResponse.Failure).errorMessage)
        }

        ApiResponse.Loading -> {


        }

    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.profile_bg),
                contentScale = ContentScale.FillWidth,
                contentDescription = ""
            )
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(35.dp, 150.dp, 35.dp, 90.dp)
            ) {
                Box(modifier = Modifier) {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {


                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Card(
                                shape = CircleShape
                            ) {
                                Image(
                                    modifier = Modifier.size(200.dp),
                                    painter = painterResource(id = R.drawable.avatar),
                                    contentDescription = null
                                )

                            }
                            TextRobotoBold(text = name, fontSize = 26, color = Lime800)
                            TextRobotoBold(text = specialization, fontSize = 18, color = Grey500)

                        }

                    }

                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row {
                        TextRobotoBold(text = "Stage: ", fontSize = 18)
                        TextRobotoLight(text = stage, fontSize = 18)
                    }
                    Row {
                        TextRobotoBold(text = "Office: ", fontSize = 18)
                        TextRobotoLight(text = "204", fontSize = 18)
                    }
                    Row {
                        TextRobotoBold(text = "Schedule: ", fontSize = 18)
                        TextRobotoLight(text = "Mon-Fri 9:00-16:00", fontSize = 18)
                    }
                    Row {
                        TextRobotoBold(text = "Email: ", fontSize = 18)
                        TextRobotoLight(text = email, fontSize = 18)
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 30.dp, 0.dp, 0.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        FloatingEditButton {

                        }
                    }

                }

            }

        }

    }

}