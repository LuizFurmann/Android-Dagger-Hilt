package com.example.androidflow.viewmodel


import com.example.androidflow.Models.MovieResponse
import com.example.androidflow.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class PostRepository @Inject constructor(private val apiService: ApiService) {

    fun getPost(): Flow<List<MovieResponse>> = flow {
        val response = apiService.getAllPosterImages()
        emit(response)
    }.flowOn(Dispatchers.IO)
}
