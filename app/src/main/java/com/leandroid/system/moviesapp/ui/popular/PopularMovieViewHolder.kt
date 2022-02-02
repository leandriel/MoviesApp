package com.leandroid.system.moviesapp.ui.popular

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.leandroid.system.moviesapp.databinding.MovieItemBinding
import com.leandroid.system.moviesapp.model.Movie
import com.squareup.picasso.Picasso

class PopularMovieViewHolder(view: View): RecyclerView.ViewHolder(view){
    private val binding = MovieItemBinding.bind(view)
    fun bind(movie: Movie){

        binding.textTitle.text = movie.originalTitle
        Picasso.get().load(movie.urlImage).into(binding.movieImage)
    }

}