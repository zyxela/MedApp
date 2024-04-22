package com.example.medapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.medapp.R
import com.example.medapp.ui.components.buttons.ActionButton
import com.example.medapp.ui.components.text.InfoText

@Composable
fun MeasureScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Box {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        modifier = Modifier.size(200.dp).padding(0.dp,0.dp,0.dp,20.dp,),
                        painter = painterResource(id = R.drawable.standing),
                        contentDescription = null
                    )
                    InfoText(text = "Standing")
                }

            }

            Box(modifier = Modifier) {
                Column {
                    ActionButton(width = 120, text = "Save") {

                    }
                    ActionButton(width = 120, text = "Start") {

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MeasureScreenPreview() {
    MeasureScreen()
}