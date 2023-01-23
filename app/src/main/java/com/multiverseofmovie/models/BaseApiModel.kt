package com.multiverseofmovie.models


import com.google.gson.annotations.SerializedName

// this is the base model for all the API calls
open class BaseApiModel(
    @SerializedName("status_code")
    val statusCode: Int = 0,
    @SerializedName("status_message")
    val statusMessage: String = "",
    @SerializedName("success")
    val success: Boolean = false,
) {
    override fun toString(): String {
        return "BaseApiModel(statusCode=$statusCode, statusMessage='$statusMessage', success=$success)"
    }
}