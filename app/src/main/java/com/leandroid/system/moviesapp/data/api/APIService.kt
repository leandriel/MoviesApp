package com.leandroid.system.moviesapp.data.api

import com.leandroid.system.moviesapp.data.dto.PopularMovieDTO
import com.leandroid.system.moviesapp.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET( "movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String = "e2bdddd0e8d2f2615afcaab831807062"): Response<PopularMovieDTO>

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = "e2bdddd0e8d2f2615afcaab831807062") : Response<Movie>
}

