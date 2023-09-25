package com.example.portifolio.network

import com.example.portifolio.model.User
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//    @GET(NetworkingConstants.URL_REPOSITORIES)
//    suspend fun getAllPosterImages(): List<MovieResponse>

    @GET("repositories")
    suspend fun getAllUser(@Query("q") query: String) : ArrayList<User>
}