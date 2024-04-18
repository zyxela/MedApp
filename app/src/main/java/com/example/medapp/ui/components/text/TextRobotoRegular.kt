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
import com.example.medapp.ui.theme.Lime800

@Composable
fun TextRobotoRegular(
    text: String,
    fontSize: Int = 16,
    color: Color = Lime800
) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = color,
        fontWeight = FontWeight(500),
        fontFamily = FontFamily(
            Font(R.font.roboto_regular)
        )
    )
}
@Preview(showBackground = true)
@Composable
fun TextRobotoRegularPreview(){
    TextRobotoRegular("Lorem ipsum")
}