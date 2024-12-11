package com.michel.nearby.data.model

import androidx.annotation.DrawableRes


data class Category(
    val id: String,
    val name: String
) {
    @get:DrawableRes
    val icon: Int?
        get() = CategoryFilterChipView.fromDrescription(description = name)?.icon
}
