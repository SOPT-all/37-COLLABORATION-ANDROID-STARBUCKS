package sopt.org.starbucks.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import sopt.org.starbucks.R

object PretendardFont {
    val Bold = FontFamily(
        Font(R.font.pretendard_bold)
    )

    val SemiBold = FontFamily(
        Font(R.font.pretendard_semibold)
    )

    val Medium = FontFamily(
        Font(R.font.pretendard_medium)
    )

    val Regular = FontFamily(
        Font(R.font.pretendard_regular)
    )
    val Light = FontFamily(
        Font(R.font.pretendard_light)
    )
}

@Immutable
data class StarbucksTypography(
    // HEAD
    val headBold21: TextStyle,
    val headBold20: TextStyle,
    val headBold17: TextStyle,
    val headSemiBold18: TextStyle,
    val headSemiBold14: TextStyle,
    val headSemiBold12: TextStyle,
    val headMedium16: TextStyle,
    val headMedium15: TextStyle,
    // BODY
    val bodyBold22: TextStyle,
    val bodyBold16: TextStyle,
    val bodySemiBold13: TextStyle,
    val bodyMedium16: TextStyle,
    val bodyRegular15: TextStyle,
    val bodyRegular15Variant: TextStyle,
    val bodyRegular13: TextStyle,
    val bodyRegular12: TextStyle,
    // CAPTION
    val captionBold11: TextStyle,
    val captionRegular14: TextStyle,
    val captionRegular13: TextStyle,
    val captionRegular12: TextStyle,
    val captionRegular12Underline: TextStyle,
    val captionRegular11: TextStyle,
    val captionRegular10: TextStyle,
    val captionLight10: TextStyle
)

private fun starbucksTextStyle(
    fontFamily: FontFamily,
    fontSize: TextUnit,
    lineHeight: TextUnit = TextUnit.Unspecified,
    letterSpacing: TextUnit = TextUnit.Unspecified,
    textDecoration: TextDecoration? = null
): TextStyle =
    TextStyle(
        fontFamily = fontFamily,
        fontSize = fontSize,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
        textDecoration = textDecoration,
        platformStyle = PlatformTextStyle(
            includeFontPadding = false
        ),
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    )

val defaultStarbucksTypography = StarbucksTypography(
    // HEAD
    headBold21 = starbucksTextStyle(
        fontFamily = PretendardFont.Bold,
        fontSize = 21.sp
    ),
    headBold20 = starbucksTextStyle(
        fontFamily = PretendardFont.Bold,
        fontSize = 20.sp
    ),
    headBold17 = starbucksTextStyle(
        fontFamily = PretendardFont.Bold,
        fontSize = 17.sp
    ),
    headSemiBold18 = starbucksTextStyle(
        fontFamily = PretendardFont.SemiBold,
        fontSize = 18.sp
    ),
    headSemiBold14 = starbucksTextStyle(
        fontFamily = PretendardFont.SemiBold,
        fontSize = 14.sp
    ),
    headSemiBold12 = starbucksTextStyle(
        fontFamily = PretendardFont.SemiBold,
        fontSize = 12.sp
    ),
    headMedium16 = starbucksTextStyle(
        fontFamily = PretendardFont.Medium,
        fontSize = 16.sp
    ),
    headMedium15 = starbucksTextStyle(
        fontFamily = PretendardFont.Medium,
        fontSize = 15.sp
    ),
    // BODY
    bodyBold22 = starbucksTextStyle(
        fontFamily = PretendardFont.Bold,
        fontSize = 22.sp
    ),
    bodyBold16 = starbucksTextStyle(
        fontFamily = PretendardFont.Bold,
        fontSize = 16.sp
    ),
    bodySemiBold13 = starbucksTextStyle(
        fontFamily = PretendardFont.SemiBold,
        fontSize = 13.sp,
        lineHeight = 1.em // 100%
    ),
    bodyMedium16 = starbucksTextStyle(
        fontFamily = PretendardFont.Medium,
        fontSize = 16.sp
    ),
    bodyRegular15 = starbucksTextStyle(
        fontFamily = PretendardFont.Regular,
        fontSize = 15.sp
    ),
    bodyRegular15Variant = starbucksTextStyle(
        fontFamily = PretendardFont.Regular,
        fontSize = 15.sp,
        lineHeight = 20.sp
    ),
    bodyRegular13 = starbucksTextStyle(
        fontFamily = PretendardFont.Regular,
        fontSize = 13.sp,
        lineHeight = 1.4.em // 140%
    ),
    bodyRegular12 = starbucksTextStyle(
        fontFamily = PretendardFont.Regular,
        fontSize = 12.sp,
        letterSpacing = 0.01.em, // 1%
        lineHeight = 1.35.em // 135%
    ),
    // CAPTION
    captionBold11 = starbucksTextStyle(
        fontFamily = PretendardFont.Bold,
        fontSize = 11.sp,
        lineHeight = 1.35.em
    ),
    captionRegular14 = starbucksTextStyle(
        fontFamily = PretendardFont.Regular,
        fontSize = 14.sp
    ),
    captionRegular13 = starbucksTextStyle(
        fontFamily = PretendardFont.Regular,
        fontSize = 13.sp
    ),
    captionRegular12 = starbucksTextStyle(
        fontFamily = PretendardFont.Regular,
        fontSize = 12.sp
    ),
    captionRegular12Underline = starbucksTextStyle(
        fontFamily = PretendardFont.Regular,
        fontSize = 12.sp,
        textDecoration = TextDecoration.Underline
    ),
    captionRegular11 = starbucksTextStyle(
        fontFamily = PretendardFont.Regular,
        fontSize = 11.sp
    ),
    captionRegular10 = starbucksTextStyle(
        fontFamily = PretendardFont.Regular,
        fontSize = 10.sp
    ),
    captionLight10 = starbucksTextStyle(
        fontFamily = PretendardFont.Light,
        fontSize = 12.sp
    )
)

val LocalStarbucksTypographyProvider = staticCompositionLocalOf { defaultStarbucksTypography }
