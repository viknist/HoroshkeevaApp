package ru.viknist.horoshkeevaapp

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface RestApi {

    @POST("auth/login/")
    suspend fun loginUser(@Body loginInfo: UserDataClass): TokenDataClass

    @POST("auth/register/")
    suspend fun registerUser(@Body registerInfo: RegisterDataClass): TokenDataClass
}

object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://78.140.243.10:9080/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}
