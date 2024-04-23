package com.example.medapp.view.visits

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.medapp.data.models.DoctorVisitResponse
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.navigation.Screen
import com.example.medapp.ui.components.ListCard
import com.example.medapp.ui.components.text.RegularText
import com.example.medapp.ui.components.text.TitleText
import com.example.medapp.ui.theme.Lime300
import com.example.medapp.ui.theme.Lime800
import com.example.medapp.utils.ApiResponse

@Composable
fun Visits(navController: NavController, viewModel: VisitsViewModel = hiltViewModel()) {

    LaunchedEffect(Unit) {
        viewModel.getVisits()
    }

    val context = LocalContext.current
    val visits by viewModel.visits.collectAsState()
    var comingVisits by remember {
        mutableStateOf<List<DoctorVisitResponse>>(emptyList())
    }
    var completedVisits by remember {
        mutableStateOf<List<DoctorVisitResponse>>(emptyList())
    }

    when (visits) {
        is ApiResponse.Success -> {
            println("win")
            val response =
                (visits as ApiResponse.Success<ResponseBody<List<DoctorVisitResponse>>>).data.data
            val _comingVisits = mutableListOf<DoctorVisitResponse>()
            val _completedVisits = mutableListOf<DoctorVisitResponse>()
            for (i in response) {
                if (i.pivot.visit_date == "") {
                    _comingVisits.add(i)
                    continue
                }
                _completedVisits.add(i)
            }
            comingVisits = _comingVisits
            completedVisits = _completedVisits
            println("win")
        }

        is ApiResponse.Failure -> {
            Toast.makeText(
                context,
                (visits as ApiResponse.Failure).errorMessage,
                Toast.LENGTH_LONG
            ).show()
            println("error")
        }

        ApiResponse.Loading -> {
            println("loading")
        }

    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(35.dp, 40.dp, 35.dp, 60.dp)
        ) {
            TitleText(text = "Your visits", textColor = Lime800, shadowColor = Color.LightGray)

            Card(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(26.dp),
                colors = CardDefaults.cardColors(containerColor = Lime300)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (comingVisits.isNotEmpty()) {
                        item {
                            RegularText(text = "Coming", fontSize = 22, color = Color.Red)
                        }
                    }

                    items(comingVisits.count()) {
                        ListCard(
                            "${comingVisits[it].firstname} ${comingVisits[it].lastname}",
                            comingVisits[it].pivot.visit_date
                        ) {
                            navController.navigate(Screen.ActionProfile.route)
                        }
                    }
                    if (completedVisits.isNotEmpty()) {
                        item {
                            RegularText(text = "Completed", fontSize = 22, color = Lime800)
                        }
                    }

                    items(completedVisits.count()) {

                        ListCard(
                            "${completedVisits[it].firstname} ${completedVisits[it].lastname}",
                            completedVisits[it].pivot.visit_date
                        ) {


                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun VisitsPreview() {
    Visits(rememberNavController())
}