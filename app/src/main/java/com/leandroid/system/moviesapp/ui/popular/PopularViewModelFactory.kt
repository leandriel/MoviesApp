package com.leandroid.system.moviesapp.ui.popular

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leandroid.system.moviesapp.data.repository.PopularRepository

class PopularViewModelFactory(private val repository: PopularRepository): ViewModelProvider.Factory {
       override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return modelClass.getConstructor(PopularRepository::class.java)
                .newInstance(repository)
        }
}