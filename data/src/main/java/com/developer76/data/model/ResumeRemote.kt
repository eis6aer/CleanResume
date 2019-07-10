package com.developer76.data.model

import com.google.gson.annotations.SerializedName

data class ResumeRemote(
    @SerializedName("name") val name: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("profile") val profile: String
)