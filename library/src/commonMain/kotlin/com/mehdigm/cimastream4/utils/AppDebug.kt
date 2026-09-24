package com.mehdigm.cimastream4.utils

import com.mehdigm.cimastream4.InternalAPI
import kotlin.concurrent.Volatile

@InternalAPI
object AppDebug {
    @Volatile
    var isDebug: Boolean = false
}
