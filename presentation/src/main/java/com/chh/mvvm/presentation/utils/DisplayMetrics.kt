
package com.chh.mvvm.presentation.utils

import android.content.res.Resources
import kotlin.math.roundToInt

val Int.px: Int get() = (this.toFloat() * Resources.getSystem().displayMetrics.density).roundToInt()