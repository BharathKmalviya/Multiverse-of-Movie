package com.multiverseofmovie.models


import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.multiverseofmovie.constants.AppConstants

@Parcelize
data class Crew(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("credit_id")
    val creditId: String = "",
    @SerializedName("department")
    val department: String = "",
    @SerializedName("gender")
    val gender: Int = 0,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("job")
    val job: String = "",
    @SerializedName("known_for_department")
    val knownForDepartment: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("original_name")
    val originalName: String = "",
    @SerializedName("popularity")
    val popularity: Double = 0.0,
    @SerializedName("profile_path")
    val profilePath: String? = null
) : Parcelable{

    fun getProfileImage() = AppConstants.IMAGE_BASE_URL+profilePath
    override fun toString(): String {
        return "Crew(adult=$adult, creditId='$creditId', department='$department', gender=$gender, id=$id, job='$job', knownForDepartment='$knownForDepartment', name='$name', originalName='$originalName', popularity=$popularity, profilePath=$profilePath)"
    }
}