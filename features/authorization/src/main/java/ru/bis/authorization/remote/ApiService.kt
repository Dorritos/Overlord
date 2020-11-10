package ru.bis.authorization.remote

import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    companion object {
        const val LOGIN = "/api/user/token"
        const val PROFILE = "/api/v1/Profile"

        const val PARAM_EMAIL = "username"
        const val PARAM_PASSWORD = "password"
    }

    @POST(LOGIN)
    fun login(@Body params: Map<String, String>): Call<String>

    @GET("$PROFILE/{id}")
    fun profile(@Path("id") id: String): Call<ProfileEntity>

}