package sopt.org.starbucks.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
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

sealed interface TypographyTokens {
    @Immutable
    data class Head(
        val headBold21: TextStyle,
        val headBold20: TextStyle,
        val headBold17: TextStyle,
        val headSemiBold18: TextStyle,
        val headSemiBold14: TextStyle,
        val headSemiBold12: TextStyle,
        val headMedium16: TextStyle,
        val headMedium15: TextStyle
    )

    @Immutable
    data class Body(
        val bodyBold22: TextStyle,
        val bodyBold16: TextStyle,
        val bodySemiBold13: TextStyle,
        val bodyMedium16: TextStyle,
        val bodyRegular15: TextStyle,
        val bodyRegular15Variant: TextStyle,
        val bodyRegular13: TextStyle,
        val bodyRegular12: TextStyle
    )

    @Immutable
    data class Caption(
        val captionBold11: TextStyle,
        val captionRegular14: TextStyle,
        val captionRegular13: TextStyle,
        val captionRegular12: TextStyle,
        val captionRegular12Underline: TextStyle,
        val captionRegular11: TextStyle,
        val captionRegular10: TextStyle,
        val captionLight10: TextStyle
    )
}

@Immutable
data class StarbucksTypography(
    val head: TypographyTokens.Head,
    val body: TypographyTokens.Body,
    val caption: TypographyTokens.Caption
)

val defaultStarbucksTypography = StarbucksTypography(
    head = TypographyTokens.Head(
        headBold21 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 21.sp
        ),
        headBold20 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 20.sp
        ),
        headBold17 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 17.sp
        ),
        headSemiBold18 = TextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 18.sp
        ),
        headSemiBold14 = TextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 14.sp
        ),
        headSemiBold12 = TextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 12.sp
        ),
        headMedium16 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 16.sp
        ),
        headMedium15 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 15.sp
        )
    ),
    body = TypographyTokens.Body(
        bodyBold22 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 22.sp
        ),
        bodyBold16 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 16.sp
        ),
        bodySemiBold13 = TextStyle(
            fontFamily = PretendardFont.SemiBold,
            fontSize = 13.sp,
            lineHeight = 13.sp // 100%
        ),
        bodyMedium16 = TextStyle(
            fontFamily = PretendardFont.Medium,
            fontSize = 16.sp
        ),
        bodyRegular15 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 15.sp
        ),
        bodyRegular15Variant = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 15.sp,
            lineHeight = 20.sp
        ),
        bodyRegular13 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 13.sp,
            lineHeight = 18.2.sp // 140%
        ),
        bodyRegular12 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 12.sp,
            letterSpacing = (-1.0).sp,
            lineHeight = 16.2.sp // 135%
        )
    ),
    caption = TypographyTokens.Caption(
        captionBold11 = TextStyle(
            fontFamily = PretendardFont.Bold,
            fontSize = 11.sp,
            lineHeight = 14.85.sp // 135%
        ),
        captionRegular14 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 14.sp
        ),
        captionRegular13 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 13.sp
        ),
        captionRegular12 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 12.sp
        ),
        captionRegular12Underline = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 12.sp,
            textDecoration = TextDecoration.Underline
        ),
        captionRegular11 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 11.sp
        ),
        captionRegular10 = TextStyle(
            fontFamily = PretendardFont.Regular,
            fontSize = 10.sp
        ),
        captionLight10 = TextStyle(
            fontFamily = PretendardFont.Light,
            fontSize = 10.sp
        )
    )
)

val LocalStarbucksTypographyProvider = staticCompositionLocalOf { defaultStarbucksTypography }
