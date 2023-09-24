package com.example.androidflow.network

import com.example.androidflow.Models.MovieResponse
import com.example.portifolio.network.NetworkingConstants
import retrofit2.http.GET

interface ApiService {
    @GET(NetworkingConstants.URL_REPOSITORIES)
    suspend fun getAllPosterImages(): List<MovieResponse>
}