package sopt.org.starbucks.core.designsystem.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = Green500,
    background = White,
    surface = White,
    onPrimary = White,
    onSecondary = White,
    onTertiary = White,
    onBackground = Black,
    onSurface = Black
)

object StarbucksTheme {
    val colors: StarbucksColors
        @Composable
        @ReadOnlyComposable
        get() = LocalStarbucksColorsProvider.current

    val typography: StarbucksTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalStarbucksTypographyProvider.current
}

@Composable
fun ProvideStarbucksColorsAndTypography(
    colors: StarbucksColors,
    typography: StarbucksTypography,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalStarbucksColorsProvider provides colors,
        LocalStarbucksTypographyProvider provides typography,
        content = content
    )
}

@Composable
fun StarbucksTheme(content: @Composable () -> Unit) {
    ProvideStarbucksColorsAndTypography(
        colors = defaultStarbucksColors,
        typography = defaultStarbucksTypography
    ) {
        val view = LocalView.current
        if (!view.isInEditMode) {
            SideEffect {
                (view.context as Activity).window.run {
                    WindowCompat.getInsetsController(this, view)
                }
            }
        }
    }
    MaterialTheme(
        colorScheme = LightColorScheme,
        content = content
    )
}
