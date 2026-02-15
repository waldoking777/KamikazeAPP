package com.muaythai.kamikaze

import androidx.annotation.DrawableRes

data class Location(
    val id: String,
    val name: String,
    val instructor: String,
    val address: String,
    val phone: String,
    val email: String,
    @DrawableRes val imageResId: Int
)
