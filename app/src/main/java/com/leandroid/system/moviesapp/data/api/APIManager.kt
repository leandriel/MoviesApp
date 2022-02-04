package com.leandroid.system.moviesapp.data.api

import com.leandroid.system.moviesapp.data.dto.PopularMovieDTO
import com.leandroid.system.moviesapp.model.Movie
import retrofit2.Response

class APIManager {

    suspend fun getPopularMovies(): Response<PopularMovieDTO> {
        return getRetrofitInstance().getPopularMovies()
    }

    suspend fun getMovieDetails(id: Int):Response<Movie>  {
        return getRetrofitInstance().getMovieDetails(id)
    }

    private fun getRetrofitInstance(): APIService {
        return Retrofit.getRetrofit().create(APIService::class.java)
    }
}