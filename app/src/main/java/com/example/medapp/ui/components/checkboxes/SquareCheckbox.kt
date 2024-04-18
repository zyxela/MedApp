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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medapp.R
import com.example.medapp.ui.theme.Lime500

@Composable
fun SquareCheckbox(
    label: String,
    isChecked: Boolean,
    modifier: Modifier = Modifier,
    size: Float = 15f,
    checkedColor: Color = Color.White,
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
        //shadow
        Box(modifier = Modifier.shadow(4.dp, shape = RectangleShape, ambientColor = Color.Red)) {
            Box(
                modifier = Modifier


            ) {

            }
            Box(
                modifier = androidx.compose.ui.Modifier
                    .size(size.dp + 6.dp)
                    .background(color = Color.White, shape = RoundedCornerShape(5.dp))
                    .border(
                        width = 1.dp,
                        color = Lime500,
                        shape = RoundedCornerShape(4.dp)
                    )

            )
            Box(
                modifier = Modifier
                    .padding(2.dp, 2.dp, 0.dp, 0.dp)
                    .size(size.dp + 2.dp)
                    .background(color = checkboxColor, shape = RectangleShape),
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
                    Icon(

                        imageVector = Icons.Default.Check,
                        contentDescription = null,
                        tint = Lime500
                    )
                }
            }
        }
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = label,
            fontFamily = FontFamily(Font(R.font.roboto_regular)),
            fontSize = 16.sp
        )
    }

}


@Preview(showBackground = true)
@Composable
fun SquareCheckboxPreview() {
    SquareCheckbox("I have agree", true) {

    }
}