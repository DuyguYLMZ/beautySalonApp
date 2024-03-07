package com.dyg.benimkuaforum.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),

)

fun lightColors() = CustomColors(
    primary = Color(0xFFE67E22),
    text = Color(0xFF000000),
    background = Color(0xFFF5F5F5),
    success = Color(0xFF2ECC71),
    error = Color(0xFFE74C3C),
    isLight = true,
)

fun darkColors() = CustomColors(
    primary = Color(0xFFDF6900),
    text = Color(0xFFFFFFFF),
    background = Color(0xFF353B48),
    success = Color(0xFF44BD32),
    error = Color(0xFFC23616),
    isLight = false,
)



@Composable
fun BenimKuaforumTheme(
    spaces: CustomSpaces = CustomTheme.spaces,
    typography: NewsTypography = CustomTheme.typography,
    colors: CustomColors = CustomTheme.colors,
    darkColors: CustomColors? = null,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val currentColor = remember { if (darkColors != null && darkTheme) darkColors else colors }
    val rememberedColors = remember { currentColor.copy() }.apply { updateColorsFrom(currentColor) }
    CompositionLocalProvider(
        LocalCustomColors provides rememberedColors,
        LocalSpaces provides spaces,
        LocalNewsTypography provides typography,
    ) {
        ProvideTextStyle(typography.body.copy(color = CustomTheme.colors.text), content = content)
    }
}

/*

@Composable
fun BenimKuaforumTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}*/