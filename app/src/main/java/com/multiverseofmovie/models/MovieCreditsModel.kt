package com.multiverseofmovie.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class MovieCreditsModel(
    @SerializedName("cast")
    val cast: List<Cast> = listOf(),
    @SerializedName("crew")
    val crew: List<Crew> = listOf(),
    @SerializedName("id")
    val id: Int = 0
) : Parcelable, BaseApiModel()