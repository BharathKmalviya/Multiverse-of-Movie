package com.multiverseofmovie.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Genre(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = ""
) : Parcelable