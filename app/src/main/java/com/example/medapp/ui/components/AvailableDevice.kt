package com.example.medapp.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.medapp.ui.components.text.RegularText
import com.example.medapp.ui.theme.Lime800

@Composable
fun AvailableDevice(text:String, action:()->Unit){
    Box (modifier = Modifier.padding(0.dp,0.dp,0.dp,10.dp)){
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(2.dp, color = Lime800, RoundedCornerShape(12.dp))
                .clickable {
                    action()
                },
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
                RegularText(text = text, color = Lime800)
            }
        }
    }
}