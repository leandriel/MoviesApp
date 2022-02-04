package com.leandroid.system.moviesapp.data.repository
import com.leandroid.system.moviesapp.data.api.APIManager
import com.leandroid.system.moviesapp.data.dto.PopularMovieDTO
import retrofit2.Response

class PopularRepository(private val apiManager: APIManager) {
     suspend fun getPopularMovies(): Response<PopularMovieDTO> {
         return apiManager.getPopularMovies()
    }
}