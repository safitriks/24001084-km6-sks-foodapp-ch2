package com.example.challenge2.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class Category (
    var id: String = UUID.randomUUID().toString(),
    @DrawableRes
    var image: Int,
    var name: String,
)