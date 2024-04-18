package com.example.medapp.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medapp.ui.components.MedicalHistoryCard
import com.example.medapp.ui.components.text.TitleText
import com.example.medapp.ui.theme.Lime800

@Composable
fun MedicalHistory() {

    var history: List<String>

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

                items(6) {
                    MedicalHistoryCard(
                        diagnoseDate = "Mar, 12 2020",
                        recoveryDate = "Apr, 52 2021",
                        recommendation = "Zanamivir 2 times everyday\n" +
                                "Terraflu 1 time everyday\n" +
                                "Limit your physical activity"
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
