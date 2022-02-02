package com.leandroid.system.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.leandroid.system.moviesapp.R
import com.leandroid.system.moviesapp.data.api.APIService
import com.leandroid.system.moviesapp.data.api.Retrofit
import com.leandroid.system.moviesapp.databinding.ActivityHomeBinding
import com.leandroid.system.moviesapp.ui.popular.PopularFragment
import com.leandroid.system.moviesapp.ui.popular.PopularMovieAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.fragment_container, PopularFragment())
        transaction.commit()
        //binding.svMovies.setOnQueryTextListener(this)
        //initRecyclerView()
        //getPopularMovies()

        // git
        // init git
        // add create remote repository
        // create develop
        // create branch
        // push commit
        // gradle



        //gradle

        //implementar retrofit dependence
        //Gson dependence
        //coroutines dependence
        //Glice dependence (imagenes)


    }

//
    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
        //searchByName(query.lowercase(Locale.getDefault()))
    }
    return true
}

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }

}