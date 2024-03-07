package com.dyg.benimkuaforum.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)


val Purple = Color(0xFF673AB7)
val DarkPurple = Color(0xFF150A28)
val HoneyFlower = Color(0xFF591165)
val Black = Color(0xFF1D1D1D)
val White = Color(0xFFF4F4F4)
val BackgroundColor = Color(0xFFF5F5F5)

@Immutable
data class Colors(
    val primary: Color,
    val background: Color,
    val onBackground: Color,
)

val LightColorTheme = Colors(
    primary = Purple,
    background = White,
    onBackground = Black,
)

val DarkColorTheme = Colors(
    primary = HoneyFlower,
    background = Black,
    onBackground = White,
)

val SpaceColorTheme = Colors(
    primary = Purple,
    background = DarkPurple,
    onBackground = White,
)

val LocalColors = staticCompositionLocalOf { LightColorTheme }