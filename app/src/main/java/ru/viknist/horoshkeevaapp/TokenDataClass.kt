package ru.viknist.horoshkeevaapp

import com.google.gson.annotations.SerializedName

data class TokenDataClass(
    @SerializedName("access_token") val accessToken: String?,
    @SerializedName("refresh_token") val refreshToken: String?,
    @SerializedName("user") val user: UserDataClass?
) : java.io.Serializable


