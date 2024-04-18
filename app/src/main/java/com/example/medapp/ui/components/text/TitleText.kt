package com.example.medapp.ui.components.text

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medapp.R


@Composable
fun TitleText(
    text: String,
    fontSize: Float = 36f,
    textColor: Color = Color.White,
    shadowColor: Color = Color.Black) {
    Box(modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 35.dp)) {
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontFamily = FontFamily(Font(R.font.sofia_sans)),
            modifier = Modifier
                .padding(2.dp)
                .blur(2.dp),
            color = shadowColor
        )
        Text(
            text = text,
            fontSize = fontSize.sp,
            fontWeight = FontWeight(500),
            fontFamily = FontFamily(Font(R.font.sofia_sans)),
            color = textColor,
        )
    }


}

@Preview(showBackground = true, backgroundColor = 12345456)
@Composable
fun TitleTextPreview() {
    TitleText(text = "Ëxample")
}