package com.mehdigm.cimastream4.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

/**
 * Maps to the XML custom attrs declared in attrs.xml:
 * TODO: Remove this comment when we migrate fully
 *  and attrs.xml will no longer be used at all.
 *
 * | XML ?attr                | Here               |
 * |--------------------------|--------------------|
 * | primaryBlackBackground   | [background]       |
 * | primaryGrayBackground    | [surfaceVariant]   |
 * | iconGrayBackground       | [surface]          |
 * | boxItemBackground        | [surfaceContainer] |
 * | textColor                | [onBackground]     |
 * | grayTextColor            | [onSurfaceVariant] |
 * | iconColor                | [icon]             |
 * | colorPrimary             | [primary]          |
 * | colorOngoing             | [ongoing]          |
 *
 * All fields are [MutableState] so Compose recomposes automatically
 * if the scheme is swapped at runtime (e.g. user changes theme without restart).
 */
@Stable
class CimaStreamColorScheme(
    background: Color,
    surfaceVariant: Color,
    surface: Color,
    surfaceContainer: Color,
    onBackground: Color,
    onSurfaceVariant: Color,
    icon: Color,
    primary: Color,
    ongoing: Color,
    isLight: Boolean,
) {
    /** primaryBlackBackground */
    var background by mutableStateOf(background)

    /** primaryGrayBackground */
    var surfaceVariant by mutableStateOf(surfaceVariant)

    /** iconGrayBackground */
    var surface by mutableStateOf(surface)

    /** boxItemBackground */
    var surfaceContainer by mutableStateOf(surfaceContainer)

    /** textColor */
    var onBackground by mutableStateOf(onBackground)

    /** grayTextColor */
    var onSurfaceVariant by mutableStateOf(onSurfaceVariant)

    /** iconColor */
    var icon by mutableStateOf(icon)

    /** colorPrimary */
    var primary by mutableStateOf(primary)

    /** colorOngoing */
    var ongoing by mutableStateOf(ongoing)
    var isLight by mutableStateOf(isLight)

    fun copy(
        background: Color = this.background,
        surfaceVariant: Color = this.surfaceVariant,
        surface: Color = this.surface,
        surfaceContainer: Color = this.surfaceContainer,
        onBackground: Color = this.onBackground,
        onSurfaceVariant: Color = this.onSurfaceVariant,
        icon: Color = this.icon,
        primary: Color = this.primary,
        ongoing: Color = this.ongoing,
        isLight: Boolean = this.isLight,
    ) = CimaStreamColorScheme(
        background, surfaceVariant, surface, surfaceContainer,
        onBackground, onSurfaceVariant, icon, primary, ongoing, isLight,
    )
}

internal fun darkScheme() = CimaStreamColorScheme(
    background = CimaStreamPalette.DarkBlackBg,
    surfaceVariant = CimaStreamPalette.DarkPrimaryGrayBg,
    surface = CimaStreamPalette.DarkIconGrayBg,
    surfaceContainer = CimaStreamPalette.DarkBoxItemBg,
    onBackground = CimaStreamPalette.DarkText,
    onSurfaceVariant = CimaStreamPalette.DarkGrayText,
    icon = CimaStreamPalette.DarkIcon,
    primary = CimaStreamPalette.Primary,
    ongoing = CimaStreamPalette.Ongoing,
    isLight = false,
)


internal fun amoledScheme() = darkScheme().copy(
    background = CimaStreamPalette.AmoledBlack,
    surface = CimaStreamPalette.AmoledBlack,
    surfaceVariant = CimaStreamPalette.AmoledBlack,
    surfaceContainer = CimaStreamPalette.AmoledBlack,
)

internal fun amoledLightScheme() = amoledScheme().copy(
    surfaceVariant = CimaStreamPalette.AmoledNearBlack,
)

internal fun lightScheme() = CimaStreamColorScheme(
    background = CimaStreamPalette.LightBlackBg,
    surfaceVariant = CimaStreamPalette.LightPrimaryGrayBg,
    surface = CimaStreamPalette.LightIconGrayBg,
    surfaceContainer = CimaStreamPalette.LightBoxItemBg,
    onBackground = CimaStreamPalette.LightText,
    onSurfaceVariant = CimaStreamPalette.LightGrayText,
    icon = CimaStreamPalette.LightIcon,
    primary = CimaStreamPalette.Primary,
    ongoing = CimaStreamPalette.Ongoing,
    isLight = true,
)

internal fun draculaScheme() = CimaStreamColorScheme(
    background = CimaStreamPalette.DraculaBlackBg,
    surfaceVariant = CimaStreamPalette.DraculaPrimaryGrayBg,
    surface = CimaStreamPalette.DraculaIconGrayBg,
    surfaceContainer = CimaStreamPalette.DraculaBoxItemBg,
    onBackground = CimaStreamPalette.DraculaText,
    onSurfaceVariant = CimaStreamPalette.DraculaGrayText,
    icon = CimaStreamPalette.DraculaIcon,
    primary = CimaStreamPalette.Primary,
    ongoing = CimaStreamPalette.Ongoing,
    isLight = false,
)

internal fun lavenderScheme() = CimaStreamColorScheme(
    background = CimaStreamPalette.LavenderBlackBg,
    surfaceVariant = CimaStreamPalette.LavenderPrimaryGrayBg,
    surface = CimaStreamPalette.LavenderIconGrayBg,
    surfaceContainer = CimaStreamPalette.LavenderBoxItemBg,
    onBackground = CimaStreamPalette.LavenderText,
    onSurfaceVariant = CimaStreamPalette.LavenderGrayText,
    icon = CimaStreamPalette.LavenderIcon,
    primary = CimaStreamPalette.Primary,
    ongoing = CimaStreamPalette.Ongoing,
    isLight = true,
)

internal fun silentBlueScheme() = CimaStreamColorScheme(
    background = CimaStreamPalette.SilentBlueBlackBg,
    surfaceVariant = CimaStreamPalette.SilentBluePrimaryGrayBg,
    surface = CimaStreamPalette.SilentBlueIconGrayBg,
    surfaceContainer = CimaStreamPalette.SilentBlueBoxItemBg,
    onBackground = CimaStreamPalette.SilentBlueText,
    onSurfaceVariant = CimaStreamPalette.SilentBlueGrayText,
    icon = CimaStreamPalette.SilentBlueIcon,
    primary = CimaStreamPalette.Primary,
    ongoing = CimaStreamPalette.Ongoing,
    isLight = false,
)