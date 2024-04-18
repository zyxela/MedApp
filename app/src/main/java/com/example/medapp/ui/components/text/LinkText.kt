package com.example.medapp.ui.components.text

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.medapp.R
import com.example.medapp.ui.theme.LinkBlue

@Composable
fun LinkText(text: String, color: Color = LinkBlue, onClick: () -> Unit) {
    Text(
        modifier = Modifier.clickable(onClick = onClick),
        text = text,
        fontFamily = FontFamily(Font(R.font.sofia_sans)),
        fontSize = 16.sp,
        color = color,
        textDecoration = TextDecoration.Underline
    )
}