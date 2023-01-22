package com.multiverseofmovie.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.multiverseofmovie.constants.AppConstants

@Parcelize
data class Cast(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("cast_id")
    val castId: Int = 0,
    @SerializedName("character")
    val character: String = "",
    @SerializedName("credit_id")
    val creditId: String = "",
    @SerializedName("gender")
    val gender: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("known_for_department")
    val knownForDepartment: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("order")
    val order: Int = 0,
    @SerializedName("original_name")
    val originalName: String = "",
    @SerializedName("popularity")
    val popularity: Double = 0.0,
    @SerializedName("profile_path")
    val profilePath: String? = null
) : Parcelable{

    fun getProfileImage() = AppConstants.IMAGE_BASE_URL+profilePath
    override fun toString(): String {
        return "Cast(adult=$adult, castId=$castId, character='$character', creditId='$creditId', gender=$gender, id=$id, knownForDepartment='$knownForDepartment', name='$name', order=$order, originalName='$originalName', popularity=$popularity, profilePath=$profilePath)"
    }
}