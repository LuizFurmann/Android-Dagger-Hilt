package com.example.androidflow.viewmodel

import android.util.Log
import androidx.lifecycle.*
import com.example.androidflow.Models.MovieResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val postRepository: PostRepository)  : ViewModel(){

    private val _response: MutableLiveData<List<MovieResponse>> = MutableLiveData()
    val response: LiveData<List<MovieResponse>> = _response
   // val postLiveData : MutableLiveData<List<MovieResponse>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            postRepository.getPost()
                .catch {e->
                    Log.e("MainViewModel_ERROR", "getPost: ${e.message}")
                }.collect {response->
                    _response.value = response
                   // postLiveData.value=response
                }

        }
    }
}