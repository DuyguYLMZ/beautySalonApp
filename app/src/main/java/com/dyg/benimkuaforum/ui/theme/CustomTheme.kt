package com.dyg.benimkuaforum.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable


object CustomTheme {

    val colors: CustomColors
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomColors.current

    val typography: NewsTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalNewsTypography.current

    val spaces: CustomSpaces
        @Composable
        @ReadOnlyComposable
        get() = LocalSpaces.current
}