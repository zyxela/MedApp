package com.example.medapp.view.medHistory

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.medapp.data.models.HistoryResponse
import com.example.medapp.data.models.ResponseBody
import com.example.medapp.ui.components.MedicalHistoryCard
import com.example.medapp.ui.components.text.TitleText
import com.example.medapp.ui.theme.Lime800
import com.example.medapp.utils.ApiResponse

@Composable
fun MedicalHistory(viewModel: MedHistoryViewModel = hiltViewModel()) {


    LaunchedEffect (Unit){
        viewModel.getMedHistory()
    }

    val historyResponse by viewModel.medHistory.collectAsState()

    var history by remember {
        mutableStateOf<List<HistoryResponse>>(emptyList())
    }

    when (historyResponse) {

        is ApiResponse.Success -> {
            val response =
                (historyResponse as ApiResponse.Success<ResponseBody<List<HistoryResponse>>>).data.data
            history = response
            println("success")
       }

        is ApiResponse.Failure -> {

            println("failure")
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
            TitleText(text = "Medical history", textColor = Lime800, shadowColor = Color.LightGray)


            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(1.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                items(history.size) {
                    MedicalHistoryCard(
                        diagnose = history[it].diagnosis,
                        diagnoseDate = history[it].diagnosis_date,
                        recoveryDate = history[it].recovery_date,
                        recommendation = history[it].diagnosis
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun MedicalHistoryPreview() {
    MedicalHistory()
}
