package com.example.medapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medapp.R
import com.example.medapp.ui.components.text.InfoText
import com.example.medapp.ui.theme.Lime500
import com.example.medapp.ui.theme.Lime800


@Composable
fun ListCard(
    text: String,
    secondText: String,
    strokeColor: Color = Lime500,
    textColor: Color = Lime800,
    action: () -> Unit
) {
    Box(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 10.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, strokeColor, RoundedCornerShape(12.dp))
                .clickable {
                    action()
                },
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Card(
                    modifier = Modifier
                        .border(2.dp, strokeColor, CircleShape)
                        .size(50.dp),
                    shape = CircleShape

                ) {
                    Image(
                        modifier = Modifier,
                        painter = painterResource(id = R.drawable.ic_launcher_foreground),
                        contentDescription = null,
                        contentScale = ContentScale.FillWidth,

                        )
                }
                Column(modifier = Modifier.padding(10.dp, 0.dp, 10.dp, 0.dp)) {
                    InfoText(text = text, color = textColor)
                    InfoText(text = secondText, color = strokeColor, fontSize = 14)
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ListCardPreview() {
    ListCard(
        "Jokn Doe",
        "Mar 12, 2022"
    ) {

    }
}