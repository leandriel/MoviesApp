package com.leandroid.system.moviesapp.data.repository

import com.leandroid.system.moviesapp.data.api.APIManager
import com.leandroid.system.moviesapp.model.Movie
import retrofit2.Response

class DetailsRepository(private val apiManager: APIManager) {
    suspend fun getMovieDetails(id: Int): Response<Movie> {
        return apiManager.getMovieDetails(id)
    }
}