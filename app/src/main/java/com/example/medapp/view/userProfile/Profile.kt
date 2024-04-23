package com.example.medapp.view.userProfile

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
import androidx.compose.ui.tooling.preview.Preview
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
fun Profile(viewModel: ProfileViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.getDoctorInfo()
    }

    val userInfo by viewModel.userInfo.collectAsState()

    var name by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }
    when (userInfo) {
        is ApiResponse.Success -> {
            val response = (userInfo as ApiResponse.Success<ResponseBody<UserResponse>>).data.data
            name = response.firstname + " " + response.lastname
            email = response.email
        }

        is ApiResponse.Failure -> {
            println((userInfo as ApiResponse.Failure).errorMessage)
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
                            TextRobotoBold(text = "Male, 54 y.o", fontSize = 18, color = Grey500)

                        }

                    }

                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row {
                        TextRobotoBold(text = "Last visit: ", fontSize = 18)
                        TextRobotoLight(text = "Today 8:40", fontSize = 18)
                    }
                    Row {
                        TextRobotoBold(text = "Address: ", fontSize = 18)
                        TextRobotoLight(text = "204, Wall st.", fontSize = 18)
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

@Preview(showBackground = true)
@Composable
fun ProfilePreview() {
    Profile()
}