package com.example.portifolio.network


import com.example.portifolio.network.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class PostRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun apiCall(query: String) = apiService.getAllUser(query)
}
