package com.leandroid.system.moviesapp.model

data class Movie(
    val id: Int,
    val originalTitle: String,
    val genreIds: MutableList<Int>,
    val posterPath: String,
    val releaseDate: String,
    val originalLanguage: String,
    val popularity: Double
)