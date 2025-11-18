package sopt.org.starbucks.core.designsystem.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

val White = Color(0xFFFFFFFF)
val Black = Color(0xFF000000)
val Transparent = Color(0x00000000)

val Green400 = Color(0xFF33B981)
val Green500 = Color(0xFF00A862)
val Green600 = Color(0xFF00864E)
val Green700 = Color(0xFF00653B)
val Green700A10 = Green700.copy(alpha = 0.1f)

val Gray100 = Color(0xFFF5F5F5)
val Gray200 = Color(0xFFDFDFDF)
val Gray300 = Color(0xFFCECECE)
val Gray400 = Color(0xFfBEBEBE)
val Gray500 = Color(0xFFAEAEAE)
val Gray600 = Color(0xFF8B8B8B)
val Gray700 = Color(0xFF686868)
val Gray800 = Color(0xFF464646)
val Gray900 = Color(0xFF232323)

val Brown = Color(0xFF966C45)
val Yellow01 = Color(0xFFC49500)
val Yellow02 = Color(0xFFF7F5Ed)
val Yellow03 = Color(0xFFFAF5E7)
val Red01 = Color(0xFFD90000)
val Red02 = Color(0xFFFDE5E3)
val Blue01 = Color(0xFF0076Ff)
val Blue02 = Color(0xFF008CC8)
val Blue03 = Color(0xFFE3F2F9)

val GreenGradient = Brush.linearGradient(
    colors = listOf(
        Color(0x00A862).copy(alpha = 0.1f),
        Color(0xFFA2F1AF)
    ),
    start = Offset(0f, 0f),
    end = Offset(0f, Float.POSITIVE_INFINITY)
)

@Immutable
data class StarbucksColors(
    val white: Color = White,
    val black: Color = Black,
    val transparent: Color = Transparent,
    val green400: Color = Green400,
    val green500: Color = Green500,
    val green600: Color = Green600,
    val green700: Color = Green700,
    val green700A10: Color = Green700A10,
    val greenGradient: Brush = GreenGradient,
    val gray100: Color = Gray100,
    val gray200: Color = Gray200,
    val gray300: Color = Gray300,
    val gray400: Color = Gray400,
    val gray500: Color = Gray500,
    val gray600: Color = Gray600,
    val gray700: Color = Gray700,
    val gray800: Color = Gray800,
    val gray900: Color = Gray900,
    val brown: Color = Brown,
    val yellow01: Color = Yellow01,
    val yellow02: Color = Yellow02,
    val yellow03: Color = Yellow03,
    val red01: Color = Red01,
    val red02: Color = Red02,
    val blue01: Color = Blue01,
    val blue02: Color = Blue02,
    val blue03: Color = Blue03
)

val defaultStarbucksColors = StarbucksColors()
val LocalStarbucksColorsProvider = staticCompositionLocalOf { defaultStarbucksColors }

@Preview(showBackground = true)
@Composable
fun GreenGradientPreview() {
    Box(
        modifier = Modifier
            .size(150.dp)
            .clip(CircleShape)
            .background(GreenGradient)
    )
}
