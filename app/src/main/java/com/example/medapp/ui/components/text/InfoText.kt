package com.example.medapp.ui.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.medapp.R

@Composable
fun InfoText(text: String, color: Color = Color.Black, fontSize:Int = 16) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.sofia_sans)),
        fontSize = fontSize.sp,
        color = color
    )
}

@Preview(showBackground = true)
@Composable
fun InfoTextPreview() {
    InfoText(text = "Lorem ipsum")
}