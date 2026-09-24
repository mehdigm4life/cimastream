package com.mehdigm.cimastream4.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

internal actual object DeviceTheme {
    @Composable
    @ReadOnlyComposable
    actual fun resolveDynamicTheme(): CimaStreamColorScheme = darkScheme()

    @Composable
    @ReadOnlyComposable
    actual fun resolveDynamicPrimaryColor(): Color = CimaStreamPrimaryColor.NORMAL.color

    @Composable
    @ReadOnlyComposable
    actual fun resolveDynamicSecondaryColor(): Color = CimaStreamPrimaryColor.NORMAL.color
}