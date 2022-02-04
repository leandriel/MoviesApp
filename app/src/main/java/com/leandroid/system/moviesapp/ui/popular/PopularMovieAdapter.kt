package com.leandroid.system.moviesapp.ui.popular

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.leandroid.system.moviesapp.R
import com.leandroid.system.moviesapp.model.Movie

class PopularMovieAdapter(private val listener: PopularMovieListener):RecyclerView.Adapter<PopularMovieViewHolder>() {
    private var movies: MutableList<Movie> = mutableListOf()
    private var originalList: MutableList<Movie> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PopularMovieViewHolder(layoutInflater.inflate(R.layout.movie_item,parent,false),listener)
    }

    override fun onBindViewHolder(holderPopular: PopularMovieViewHolder, position: Int) {
        val item = movies[position]
        holderPopular.bind(item)

    }

    override fun getItemCount(): Int = movies.size

    fun setMovies(movies: MutableList<Movie>){
        this.originalList = movies
        this.movies = movies
        notifyDataSetChanged()
    }

    fun getMoviesByName(name: String){
        if (name.isEmpty()){
            this.movies = originalList
        }else {
            this.movies = originalList.filter {
                it.originalTitle.contains(name)
            }.toMutableList()
        }
    }
}