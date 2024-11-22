package com.example.courses.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val stringRes: Int,
    val hard:Int,
    @DrawableRes val imgRes: Int,
)
