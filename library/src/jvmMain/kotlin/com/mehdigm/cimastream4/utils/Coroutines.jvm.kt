package com.mehdigm.cimastream4.utils

import androidx.annotation.AnyThread
import androidx.annotation.MainThread

@AnyThread
actual fun runOnMainThreadNative(@MainThread work: () -> Unit) {
    work.invoke()
}
