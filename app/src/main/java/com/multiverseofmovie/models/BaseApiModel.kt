package com.multiverseofmovie.models


import com.google.gson.annotations.SerializedName

open class BaseApiModel(
    @SerializedName("status_code")
    val statusCode: Int = 0,
    @SerializedName("status_message")
    val statusMessage: String = "",
    @SerializedName("success")
    val success: Boolean = false,
) {

}