package com.example.portifolio.network

import com.example.androidflow.Models.MovieResponse
import com.example.portifolio.Models.User
import com.example.portifolio.network.NetworkingConstants
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
//    @GET(NetworkingConstants.URL_REPOSITORIES)
//    suspend fun getAllPosterImages(): List<MovieResponse>

    @GET("repositories")
    fun getAllUser(@Query("q") query: String) : ArrayList<User>
}