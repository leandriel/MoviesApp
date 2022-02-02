package com.leandroid.system.moviesapp.ui.popular

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandroid.system.moviesapp.R
import com.leandroid.system.moviesapp.data.api.APIService
import com.leandroid.system.moviesapp.data.api.Retrofit
import com.leandroid.system.moviesapp.databinding.FragmentPopularBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularFragment : Fragment() {
    private lateinit var binding: FragmentPopularBinding
    private lateinit var adapterPopular: PopularMovieAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        getPopularMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun getPopularMovies(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = Retrofit.getRetrofit().create(APIService::class.java).getPopularMovies()
            print(response)
            withContext(Dispatchers.Main){
                if (response.isSuccessful) {
                    val response = response.body()
                    val movies = response?.results ?: mutableListOf()
                    adapterPopular.setMovies(movies)
                } else {
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(requireContext(),"Ha ocurrido un error", Toast.LENGTH_LONG).show()
    }

    private fun initRecyclerView() {
        adapterPopular = PopularMovieAdapter()
        binding.moviesRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.moviesRecycler.adapter = adapterPopular
    }
}