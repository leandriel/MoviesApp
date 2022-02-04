package com.leandroid.system.moviesapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.leandroid.system.moviesapp.R
import com.leandroid.system.moviesapp.databinding.ActivityHomeBinding
import com.leandroid.system.moviesapp.ui.popular.PopularFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, PopularFragment())
            commit()
        }
    }
}