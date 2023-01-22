package com.multiverseofmovie.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class BelongsToCollection(
    @SerializedName("backdrop_path")
    val backdropPath: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("poster_path")
    val posterPath: String = ""
) : Parcelable