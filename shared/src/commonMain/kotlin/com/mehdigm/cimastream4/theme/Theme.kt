package com.mehdigm.cimastream4.theme

import androidx.compose.animation.core.InfiniteTransition
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

enum class CimaStreamThemeMode {
    /** "Black" standard dark, #111111 backgrounds */
    Dark,

    /** "Amoled" / "AmoledLight" pure black (#000000) */
    Amoled,

    /** "AmoledLight" pure black (#000000) */
    AmoledLight,

    /** "Light" white/gray backgrounds, dark text */
    Light,

    /** "Dracula" */
    Dracula,

    /** "Lavender" */
    Lavender,

    /** "SilentBlue" */
    SilentBlue,

    /** "System" resolved on each platform via [isSystemInDarkTheme] */
    FollowSystem,

    /**
     * Uses platform dynamic color system, Material You on Android 12+,
     * falls back to [Dark] on unsupported platforms.
     */
    Dynamic,
}

@Composable
fun modeToTheme(mode : CimaStreamThemeMode, primaryColor: CimaStreamPrimaryColor) : CimaStreamColorScheme {
    val dynamicTheme = DeviceTheme.resolveDynamicTheme()
    val dynamicPrimary = DeviceTheme.resolveDynamicPrimaryColor()
    val dynamicSecondary = DeviceTheme.resolveDynamicSecondaryColor()
    val systemDark = isSystemInDarkTheme()
    val color = remember(mode, primaryColor, systemDark, dynamicTheme, dynamicPrimary, dynamicSecondary) {
        val base = when (mode) {
            CimaStreamThemeMode.Dark -> darkScheme()
            CimaStreamThemeMode.Amoled -> amoledScheme()
            CimaStreamThemeMode.AmoledLight -> amoledLightScheme()
            CimaStreamThemeMode.Light -> lightScheme()
            CimaStreamThemeMode.Dracula -> draculaScheme()
            CimaStreamThemeMode.Lavender -> lavenderScheme()
            CimaStreamThemeMode.SilentBlue -> silentBlueScheme()
            CimaStreamThemeMode.FollowSystem -> if (systemDark) darkScheme() else lightScheme()
            CimaStreamThemeMode.Dynamic -> dynamicTheme
        }
        when {
            mode == CimaStreamThemeMode.Dynamic -> base
            primaryColor == CimaStreamPrimaryColor.DYNAMIC -> base.copy(primary = dynamicPrimary)
            primaryColor == CimaStreamPrimaryColor.DYNAMIC_TWO -> base.copy(primary = dynamicSecondary)
            else -> base.copy(primary = primaryColor.color)
        }
    }
    return color
}

private fun CimaStreamColorScheme.toMaterial3ColorScheme() = if (isLight) {
    lightColorScheme(
        primary = primary,
        background = background,
        surface = surface,
        surfaceVariant = surfaceVariant,
        surfaceContainer = surfaceContainer,
        onBackground = onBackground,
        onSurface = onBackground,
        onSurfaceVariant = onSurfaceVariant,
        onPrimary = Color.White,
    )
} else {
    darkColorScheme(
        primary = primary,
        background = background,
        surface = surface,
        surfaceVariant = surfaceVariant,
        surfaceContainer = surfaceContainer,
        onBackground = onBackground,
        onSurface = onBackground,
        onSurfaceVariant = onSurfaceVariant,
        onPrimary = Color.White,
    )
}

internal val LocalSharedInfiniteTransition = staticCompositionLocalOf<InfiniteTransition> { throw NotImplementedError() }

/**
 * Global synchronized animation, so many items in e.g. a LazyList can animate at the same time,
 * even if they appeared at different times
 * */
@Composable
@ReadOnlyComposable
fun MaterialTheme.infiniteSharedTransition() = LocalSharedInfiniteTransition.current

@Composable
fun CimaStreamPreviewTheme(content: @Composable () -> Unit) {
    CimaStreamTheme(content = content)
}

@Composable
fun CimaStreamTheme(
    mode: CimaStreamThemeMode = CimaStreamThemeMode.FollowSystem,
    primaryColor: CimaStreamPrimaryColor = CimaStreamPrimaryColor.NORMAL,
    content: @Composable () -> Unit,
) {
    val csColors = modeToTheme(mode, primaryColor)
    val globalTransition = rememberInfiniteTransition(label = "GlobalSharedTransition")
    // We do not provide csColors as a global, because people should use MaterialTheme directly instead
    CompositionLocalProvider(LocalSharedInfiniteTransition provides globalTransition) {
        MaterialTheme(
            colorScheme = csColors.toMaterial3ColorScheme(),
            content = content,
            typography = AppFont.typography
        )
    }
}