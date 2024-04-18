package com.example.medapp.ui.components.checkboxes

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medapp.R
import com.example.medapp.ui.theme.Lime500
import com.example.medapp.ui.theme.Lime800

@Composable
fun CircleCheckBox(
    label: String,
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    size: Float = 20f,
    checkedColor: Color = Lime800,
    uncheckedColor: Color = Color.White,
    onValueChange: (Boolean) -> Unit
) {
    val checkboxColor: Color by animateColorAsState(if (isChecked) checkedColor else uncheckedColor)
    val density = LocalDensity.current
    val duration = 200

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .heightIn(48.dp) // height of 48dp to comply with minimum touch target size
            .toggleable(
                value = isChecked,
                role = Role.Checkbox,
                onValueChange = onValueChange
            )
    ) {
        Box(modifier = Modifier.shadow(4.dp, shape = CircleShape, ambientColor = Color.Red)) {
            Box(
                modifier = Modifier
                    .padding(0.5.dp, 4.dp, 0.dp, 0.dp)
                    .size(size.dp + 5.dp)
                    .background(color = Color(0, 0, 0, 22), shape = CircleShape)
                    .blur(66.dp),

                ) {

            }
            Box(
                modifier = Modifier
                    .size(size.dp + 6.dp)
                    .background(color = Color.White, shape = CircleShape)
                    .border(
                        width = 3.dp,
                        color = Lime500,
                        shape = RoundedCornerShape(64.dp)
                    )

            )
            Box(
                modifier = Modifier
                    .padding(6.dp, 6.dp, 0.dp, 0.dp)
                    .size(size.dp - 6.dp)
                    .background(color = checkboxColor, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                androidx.compose.animation.AnimatedVisibility(
                    visible = isChecked,
                    enter = slideInHorizontally(animationSpec = tween(duration)) {
                        with(density) { (size * -0.5).dp.roundToPx() }
                    } + expandHorizontally(
                        expandFrom = Alignment.Start,
                        animationSpec = tween(duration)
                    ),
                    exit = fadeOut()
                ) {

                }
            }
        }
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = label,
            fontFamily = FontFamily(Font(R.font.sofia_sans)),
            fontSize = 18.sp
        )
    }

}

@Preview(showBackground = true)
@Composable
fun CircleCheckBoxPreview() {
    CircleCheckBox(
        label = "doctor",
        isChecked = true,
    ) {

    }
}