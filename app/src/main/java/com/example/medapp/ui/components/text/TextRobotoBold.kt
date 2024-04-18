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
import com.example.medapp.ui.theme.Grey500

@Composable
fun TextRobotoBold(
    text: String,
    fontSize: Int = 16,
    color: Color = Grey500
) {
    Text(
        text = text,
        fontSize = fontSize.sp,
        color = color,
        fontWeight = FontWeight(700),
        fontFamily = FontFamily(Font(R.font.roboto_bold)
        )
    )
}
@Preview(showBackground = true)
@Composable
fun TextRobotoBoldPreview(){
    TextRobotoBold("Lorem ipsum")
}