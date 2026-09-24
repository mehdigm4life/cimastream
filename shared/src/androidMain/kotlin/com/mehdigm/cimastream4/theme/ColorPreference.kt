package com.mehdigm.cimastream4.theme

import android.content.Context
import android.os.Build
import androidx.preference.PreferenceManager

/** TODO: This should be replaced with a better system */

fun perfToMode(perf: String?) =
    when (perf) {
        "System" -> CimaStreamThemeMode.FollowSystem
        "Black" -> CimaStreamThemeMode.Dark
        "Light" -> CimaStreamThemeMode.Light
        "Amoled" -> CimaStreamThemeMode.Amoled
        "AmoledLight" -> CimaStreamThemeMode.AmoledLight
        "Dracula" -> CimaStreamThemeMode.Dracula
        "Lavender" -> CimaStreamThemeMode.Lavender
        "SilentBlue" -> CimaStreamThemeMode.SilentBlue
        "Monet" -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            CimaStreamThemeMode.Dynamic
        } else {
            CimaStreamThemeMode.Dark
        }

        else -> CimaStreamThemeMode.Dark
    }

fun perfToColor(perf : String?) = when (perf) {
    "Normal" -> CimaStreamPrimaryColor.NORMAL
    "Blue" -> CimaStreamPrimaryColor.BLUE
    "Purple" -> CimaStreamPrimaryColor.PURPLE
    "Green" -> CimaStreamPrimaryColor.GREEN
    "GreenApple" -> CimaStreamPrimaryColor.GREEN_APPLE
    "Red" -> CimaStreamPrimaryColor.RED
    "Banana" -> CimaStreamPrimaryColor.BANANA
    "Party" -> CimaStreamPrimaryColor.PARTY
    "Pink" -> CimaStreamPrimaryColor.PINK
    "CarnationPink" -> CimaStreamPrimaryColor.CARNATION_PINK
    "Maroon" -> CimaStreamPrimaryColor.MAROON
    "DarkGreen" -> CimaStreamPrimaryColor.DARK_GREEN
    "NavyBlue" -> CimaStreamPrimaryColor.NAVY_BLUE
    "Grey" -> CimaStreamPrimaryColor.GREY
    "White" -> CimaStreamPrimaryColor.WHITE
    "Brown" -> CimaStreamPrimaryColor.BROWN
    "Orange" -> CimaStreamPrimaryColor.ORANGE
    "DandelionYellow" -> CimaStreamPrimaryColor.DANDELION_YELLOW
    "CoolBlue" -> CimaStreamPrimaryColor.COOL_BLUE
    "Lavender" -> CimaStreamPrimaryColor.LAVENDER
    "Monet" -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        CimaStreamPrimaryColor.DYNAMIC
    } else {
        CimaStreamPrimaryColor.NORMAL
    }

    "Monet2" -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
        CimaStreamPrimaryColor.DYNAMIC_TWO
    } else {
        CimaStreamPrimaryColor.NORMAL
    }

    else -> CimaStreamPrimaryColor.NORMAL
}

fun Context.loadThemeMode(): CimaStreamThemeMode {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
    return perfToMode(prefs.getString("theme_key", "AmoledLight"))
}

fun Context.loadPrimaryColor(): CimaStreamPrimaryColor {
    val prefs = PreferenceManager.getDefaultSharedPreferences(this)
    return perfToColor(prefs.getString("primary_color_key", "Normal"))
}