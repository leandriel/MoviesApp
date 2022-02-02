package com.leandroid.system.moviesapp.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("id") val id: Int,
    @SerializedName("original_title") val originalTitle: String,
    @SerializedName("genre_ids") val genreIds: MutableList<Int>,
    @SerializedName("poster_path") val images: String,
    @SerializedName("release_date") val releaseDate: String,
    @SerializedName("original_language") val originalLanguage: String,
    @SerializedName("popularity") val popularity: Double
){
    var urlImage : String = ""
        get() = "https://image.tmdb.org/t/p/w500/${images}"
}