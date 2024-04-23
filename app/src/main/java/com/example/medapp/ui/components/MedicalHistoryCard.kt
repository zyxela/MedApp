package com.example.medapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medapp.ui.components.text.InfoText
import com.example.medapp.ui.components.text.RegularText
import com.example.medapp.ui.theme.Lime500
import com.example.medapp.ui.theme.Lime800

@Composable
fun MedicalHistoryCard(diagnose:String, diagnoseDate: String, recoveryDate: String, recommendation: String) {
    Card(
        modifier = Modifier.padding(0.dp,0.dp,0.dp,15.dp).shadow(2.dp, shape = RoundedCornerShape(12.dp)),
        colors = CardDefaults.cardColors(Color.White, Color.White, Color.White, Color.White)) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .shadow(10.dp, ambientColor = Color.Black, spotColor = Color.Black)
            ) {
                Box(
                    modifier = Modifier
                        .background(Lime500)
                        .fillMaxWidth()
                        .padding(15.dp)
                ) {
                    RegularText(text = diagnose, color = Color.White, fontSize = 26)
                }

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)

            ) {
                Column {


                    Row(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)) {
                        RegularText(text = "Diagnose date: ", color = Lime800, fontSize = 18)
                        InfoText(text = diagnoseDate, fontSize = 18, color = Lime500)
                    }
                    Row(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)) {
                        RegularText(text = "Recovery date: ", color = Lime800, fontSize = 18)
                        InfoText(text = recoveryDate, fontSize = 18, color = Lime500)
                    }
                    Column(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 5.dp)) {
                        RegularText(text = "Recommendations: ", color = Lime800, fontSize = 18)
                        InfoText(
                            text = recommendation, fontSize = 18, color = Lime500
                        )
                    }
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MedicalHistoryCardPreview() {
    MedicalHistoryCard("Influenza",
        "Feb, 18 2020", "Mar, 18 2020", "Zanamivir 2 times everyday\n" +
                "Terraflu 1 time everyday\n" +
                "Limit your physical activity"
    )
}