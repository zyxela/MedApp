package com.example.medapp.ui.components.buttons

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.example.medapp.ui.theme.Lime500

@Composable
fun FloatingEditButton(
    modifier: Modifier = Modifier,
    imageVector: ImageVector = Icons.Default.Edit,
    onClick: () -> Unit
) {
    FloatingActionButton(
        modifier = modifier,
        onClick = onClick,
        shape = CircleShape,
        containerColor = Lime500,
        contentColor = Color.White
    ) {
        Icon(imageVector, "Large floating action button")
    }
}

@Preview
@Composable
fun FloatingEditButtonPreview() {
    FloatingEditButton() {

    }
}