package com.example.pitjarustest.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Blue80,
    secondary = PurpleGrey40,
    tertiary = Pink40
)

private val LightColorPalette = PitjarusTestColors(
    gradient6_1 = listOf(Shadow4, Ocean3, Shadow2, Ocean3, Shadow4),
    gradient6_2 = listOf(Rose4, Lavender3, Rose2, Lavender3, Rose4),
    gradient2_1 = listOf(Shadow4, Shadow11),
    gradient2_2 = listOf(Ocean3, Shadow3),
    textInteractive = Neutral0,
    uiBorder = Neutral4,
    uiBackground = Neutral0,
    brand = Shadow5,
    textSecondary = Neutral7,
    textLink = Ocean11,
    textHelp = Neutral6,
    iconInteractive = Neutral0,
    tornado1 = listOf(Shadow4, Ocean3),
    isDark = false
)

private val DarkColorPalette = PitjarusTestColors(
    gradient6_1 = listOf(Shadow5, Ocean7, Shadow9, Ocean7, Shadow5),
    gradient6_2 = listOf(Rose11, Lavender7, Rose8, Lavender7, Rose11),
    gradient2_1 = listOf(Ocean3, Shadow3),
    gradient2_2 = listOf(Ocean4, Shadow2),
    textInteractive = Neutral7,
    uiBorder = Neutral3,
    uiBackground = Neutral8,
    brand = Shadow1,
    textPrimary = Shadow1,
    textSecondary = Neutral0,
    textLink = Ocean2,
    textHelp = Neutral1,
    iconInteractive = Neutral7,
    tornado1 = listOf(Shadow4, Ocean3),
    isDark = true
)

@Composable
fun PitjarusTestTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    //dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    /*val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }*/
    val colors = if (darkTheme) DarkColorPalette else LightColorPalette
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    ProvidePitjarusTestColors(colors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}

object PitjarusTestTheme {
    val colors: PitjarusTestColors
        @Composable
        get() = LocalPitjarusTestColors.current
}

@Stable
class PitjarusTestColors(
    gradient6_1: List<Color>,
    gradient6_2: List<Color>,
    gradient2_1: List<Color>,
    gradient2_2: List<Color>,
    textInteractive: Color,
    interactivePrimary: List<Color> = gradient2_1,
    interactiveSecondary: List<Color> = gradient2_2,
    uiBorder: Color,
    uiBackground: Color,
    brand: Color,
    textPrimary: Color = brand,
    textSecondary: Color,
    textLink: Color,
    textHelp: Color,
    iconInteractive: Color,
    tornado1: List<Color>,
    isDark: Boolean
) {
    var gradient61 by mutableStateOf(gradient6_1)
        private set
    var gradient62 by mutableStateOf(gradient6_2)
        private set
    var gradient21 by mutableStateOf(gradient2_1)
        private set
    var gradient22 by mutableStateOf(gradient2_2)
        private set
    var textInteractive by mutableStateOf(textInteractive)
        private set
    var interactivePrimary by mutableStateOf(interactivePrimary)
        private set
    var interactiveSecondary by mutableStateOf(interactiveSecondary)
        private set
    var uiBorder by mutableStateOf(uiBorder)
        private set
    var uiBackground by mutableStateOf(uiBackground)
        private set
    var brand by mutableStateOf(brand)
        private set
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textLink by mutableStateOf(textLink)
        private set
    var textHelp by mutableStateOf(textHelp)
        private set
    var iconInteractive by mutableStateOf(iconInteractive)
        private set
    var tornado1 by mutableStateOf(tornado1)
        private set
    var isDark by mutableStateOf(isDark)
        private set

    fun update(other: PitjarusTestColors) {
        gradient61 = other.gradient61
        gradient62 = other.gradient62
        gradient21 = other.gradient21
        gradient22 = other.gradient22
        textInteractive = other.textInteractive
        interactivePrimary = other.interactivePrimary
        interactiveSecondary = other.interactiveSecondary
        uiBorder = other.uiBorder
        uiBackground = other.uiBackground
        brand = other.brand
        textPrimary = other.textPrimary
        textSecondary = other.textSecondary
        textLink = other.textLink
        textHelp = other.textHelp
        iconInteractive = other.iconInteractive
        tornado1 = other.tornado1
        isDark = other.isDark
    }

    fun copy(): PitjarusTestColors = PitjarusTestColors(
        gradient6_1 = gradient61,
        gradient6_2 = gradient62,
        gradient2_1 = gradient21,
        gradient2_2 = gradient22,
        textInteractive = textInteractive,
        interactivePrimary = interactivePrimary,
        interactiveSecondary = interactiveSecondary,
        uiBorder = uiBorder,
        uiBackground = uiBackground,
        brand = brand,
        textPrimary = textPrimary,
        textSecondary = textSecondary,
        textLink = textLink,
        textHelp = textHelp,
        iconInteractive = iconInteractive,
        tornado1 = tornado1,
        isDark = isDark
    )
}

@Composable
fun ProvidePitjarusTestColors(
    colors: PitjarusTestColors,
    content: @Composable () -> Unit
) {
    val colorPalette = remember {
        // Explicitly creating a new object here so we don't mutate the initial [colors]
        // provided, and overwrite the values set in it.
        colors.copy()
    }
    colorPalette.update(colors)
    CompositionLocalProvider(LocalPitjarusTestColors provides colorPalette, content = content)
}

private val LocalPitjarusTestColors = staticCompositionLocalOf<PitjarusTestColors> {
    error("No JetsnackColorPalette provided")
}