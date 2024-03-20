package com.example.challenge2.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import java.util.UUID
@Parcelize
data class Catalog (
    var id: String = UUID.randomUUID().toString(),
    @DrawableRes
    var image: Int,
    var price: Double,
    var details: String,
    var name: String,
    var location: String,
    var locationUrl: String
) : Parcelable