package com.leandroid.system.moviesapp.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.leandroid.system.moviesapp.R
import com.leandroid.system.moviesapp.databinding.ActivityDetailsMovieBinding

class DetailsMovieActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsMovieBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}