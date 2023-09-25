package com.example.portifolio.viewmodel

import androidx.lifecycle.*
import com.example.portifolio.model.User
import com.example.portifolio.network.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val postRepository: PostRepository)  : ViewModel(){

    private val _response: MutableLiveData<ArrayList<User>> = MutableLiveData()
    val response: LiveData<ArrayList<User>> = _response
   // val postLiveData : MutableLiveData<List<MovieResponse>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            val response = postRepository.apiCall("ny")
            _response.postValue(response)

        }
    }
}