package com.bayaz.app.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = LapisPrimaryLight,
    onPrimary = CardSurfaceLight,
    secondary = OchreSecondaryLight,
    onSecondary = CardSurfaceLight,
    tertiary = TerracottaTertiaryLight,
    onTertiary = CardSurfaceLight,
    background = ParchmentBackgroundLight,
    onBackground = TextPrimaryLight,
    surface = CardSurfaceLight,
    onSurface = TextPrimaryLight,
    surfaceVariant = ParchmentBackgroundLight,
    onSurfaceVariant = TextMutedLight
)

private val DarkColorScheme = darkColorScheme(
    primary = LapisPrimaryDark,
    onPrimary = BasaltBackgroundDark,
    secondary = OchreSecondaryDark,
    onSecondary = BasaltBackgroundDark,
    tertiary = TerracottaTertiaryDark,
    onTertiary = BasaltBackgroundDark,
    background = BasaltBackgroundDark,
    onBackground = TextPrimaryDark,
    surface = CharcoalSurfaceDark,
    onSurface = TextPrimaryDark,
    surfaceVariant = CharcoalSurfaceDark,
    onSurfaceVariant = TextMutedDark
)

@Composable
fun BayazTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current

    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as? Activity)?.window
            if (window != null) {
                window.statusBarColor = colorScheme.background.toArgb()
                window.navigationBarColor = colorScheme.background.toArgb()
                val insetsController = WindowCompat.getInsetsController(window, view)
                insetsController.isAppearanceLightStatusBars = !darkTheme
                insetsController.isAppearanceLightNavigationBars = !darkTheme
            }
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = BayazTypography,
        content = content
    )
}