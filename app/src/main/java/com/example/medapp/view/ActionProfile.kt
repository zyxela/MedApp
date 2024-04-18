package com.example.medapp.view

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.medapp.R
import com.example.medapp.navigation.Screen
import com.example.medapp.ui.components.buttons.FloatingEditButton
import com.example.medapp.ui.components.text.TextRobotoBold
import com.example.medapp.ui.components.text.TextRobotoLight
import com.example.medapp.ui.theme.Grey500
import com.example.medapp.ui.theme.Lime800

@Composable
fun ActionProfile(navController: NavController) {
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
                                    painter = painterResource(id = R.drawable.ic_launcher_background),
                                    contentDescription = null
                                )

                            }
                            TextRobotoBold(text = "John Dee", fontSize = 26, color = Lime800)
                            TextRobotoBold(text = "patient", fontSize = 18, color = Grey500)

                        }

                    }

                }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row {
                        TextRobotoBold(text = "Stage: ", fontSize = 18)
                        TextRobotoLight(text = "5 yers", fontSize = 18)
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
                        TextRobotoLight(text = "jason.statham@mail.ru", fontSize = 18)
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 30.dp, 0.dp, 0.dp),
                        horizontalArrangement = Arrangement.End
                    ) {
                        FloatingEditButton(imageVector = Icons.TwoTone.Settings) {
                            navController.navigate(Screen.Devices.route)
                        }
                    }

                }

            }

        }

    }

}

@Preview
@Composable
fun ActionProfilePreview() {
    ActionProfile(rememberNavController())
}