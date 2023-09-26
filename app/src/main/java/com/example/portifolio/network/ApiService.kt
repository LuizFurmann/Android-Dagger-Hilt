package com.example.portifolio.network

import com.example.portifolio.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("repositories")
    suspend fun getAllUser(@Query("q") query: String) : ArrayList<User>
}