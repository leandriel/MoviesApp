package com.leandroid.system.moviesapp.ui.popular

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandroid.system.moviesapp.R
import com.leandroid.system.moviesapp.data.ComponentUtils.Companion.showToast
import com.leandroid.system.moviesapp.data.api.APIManager
import com.leandroid.system.moviesapp.data.api.APIService
import com.leandroid.system.moviesapp.data.api.Retrofit
import com.leandroid.system.moviesapp.data.api.Retrofit.Companion.getRetrofit
import com.leandroid.system.moviesapp.data.repository.PopularRepository
import com.leandroid.system.moviesapp.databinding.FragmentPopularBinding
import com.leandroid.system.moviesapp.ui.details.DetailsMovieActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PopularFragment : Fragment(),PopularMovieListener {
    private lateinit var binding: FragmentPopularBinding
    private lateinit var adapterPopular: PopularMovieAdapter
    private val repository = PopularRepository(APIManager())
    private lateinit var viewModel: PopularViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initRecyclerView()
        subscribeLiveData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPopularBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun initViewModel(){
        PopularViewModelFactory(repository).run {
            viewModel = ViewModelProvider(this@PopularFragment, this)[PopularViewModel::class.java]
        }
    }

    private fun subscribeLiveData(){
        with(viewModel){
            getPopularMovies()
            isLoading.observe(viewLifecycleOwner) {
               if(it){
                   //mostrar loadign
               } else {
                   //ocultar loading
               }
            }

            isError.observe(viewLifecycleOwner){
                if(it){
                    showError()
                }
            }

            movies.observe(viewLifecycleOwner) {
                adapterPopular.setMovies(it)
            }
        }
    }

    private fun showError() {
        showToast(requireContext(),getString(R.string.error_toast))
    }

    private fun initRecyclerView() {
        adapterPopular = PopularMovieAdapter(this)
        binding.moviesRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterPopular
        }
    }

    override fun onClick(id: Int) {
        val intent = Intent(requireContext(), DetailsMovieActivity::class.java)
        intent.putExtra(DetailsMovieActivity.ID_MOVIE, id)
        startActivity(intent)
    }
}