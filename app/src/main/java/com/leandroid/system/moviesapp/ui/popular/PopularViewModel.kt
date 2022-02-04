package com.leandroid.system.moviesapp.ui.popular

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leandroid.system.moviesapp.data.api.APIService
import com.leandroid.system.moviesapp.data.api.Retrofit.Companion.getRetrofit
import com.leandroid.system.moviesapp.data.repository.PopularRepository
import com.leandroid.system.moviesapp.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit

class PopularViewModel(private val repository: PopularRepository) : ViewModel(){
    val movies: LiveData<MutableList<Movie>>
        get() = _movies
    private val _movies = MutableLiveData<MutableList<Movie>>()
    val isError: LiveData<Boolean>
        get() = _isError
    private val _isError = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading
    private val _isLoading = MutableLiveData<Boolean>()

    fun getPopularMovies(){
        viewModelScope.launch {
            _isLoading.value = true
            repository.getPopularMovies().let { response ->
                if (response.isSuccessful) {
                    _isError.value = false
                    _movies.value = response.body()?.let {
                        it.results
                    } ?: mutableListOf()
                } else {
                   _isError.value = true
                }
                _isLoading.value = false
            }
        }
    }
}