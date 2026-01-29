package com.whatjustchanged.core.ui

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val LightColorScheme = lightColorScheme(
    primary = AppColors.AccentPrimary,
    onPrimary = AppColors.ButtonTextPrimary,
    secondary = AppColors.AccentHover,
    tertiary = AppColors.WarmHighlightBackground,
    background = AppColors.BackgroundPrimary,
    onBackground = AppColors.TextPrimary,
    surface = AppColors.CardBackground,
    onSurface = AppColors.TextPrimary,
    surfaceVariant = AppColors.BackgroundSecondary,
    onSurfaceVariant = AppColors.TextSecondary,
    outline = AppColors.Divider
)

@Composable
fun MarkdTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false, // Disabled by default to enforce our design token
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme // We only have a light theme for now based on the design

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
