package ru.viknist.horoshkeevaapp

import com.google.gson.annotations.SerializedName

data class UserDataClass(
    @SerializedName("id") val idUser: Int?,
    @SerializedName("username") val username: String?,
    @SerializedName("email") val email: String?,
    @SerializedName("password") val password: String?
) : java.io.Serializable
