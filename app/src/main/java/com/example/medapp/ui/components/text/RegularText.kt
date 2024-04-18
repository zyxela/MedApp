package com.example.medapp.ui.components.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.medapp.R

@Composable
fun RegularText(text: String, color: Color = Color.Black, fontSize:Int = 20) {
    Text(
        text = text,
        fontFamily = FontFamily(Font(R.font.sofia_sans)),
        fontSize = fontSize.sp,
        color = color,
        fontWeight = FontWeight(600)
    )
}

@Preview(showBackground = true)
@Composable
fun RegularTextPreview() {
    RegularText(text = "Lorem ipsum")
}