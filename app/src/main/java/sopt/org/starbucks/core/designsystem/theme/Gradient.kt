package sopt.org.starbucks.core.designsystem.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val StarbucksGradient = Brush.linearGradient(
    colors = listOf(
        GreenGradientStart,
        GreenGradientEnd
    ),
    start = Offset(0f, 0f),
    end = Offset(300f, 500f)
)

@Preview(showBackground = true)
@Composable
fun StarbucksGradientPreview() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .background(StarbucksGradient)
    )
}
