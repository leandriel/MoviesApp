package com.leandroid.system.moviesapp.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.leandroid.system.moviesapp.R
import com.leandroid.system.moviesapp.data.ComponentUtils.Companion.showToast
import com.leandroid.system.moviesapp.data.api.APIManager
import com.leandroid.system.moviesapp.data.repository.DetailsRepository
import com.leandroid.system.moviesapp.databinding.ActivityDetailsMovieBinding
import com.squareup.picasso.Picasso

class DetailsMovieActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailsViewModel
    private val repository = DetailsRepository(APIManager())
    lateinit var binding: ActivityDetailsMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val id: Int = intent.getIntExtra(ID_MOVIE,0)
        initViewModel()
        subscribeLiveData()
        viewModel.getDetailsMovie(id)
    }

    private fun initViewModel(){
        DetailsViewModelFactory(repository).run {
            viewModel = ViewModelProvider(this@DetailsMovieActivity, this)[DetailsViewModel::class.java]
        }
    }

    private fun subscribeLiveData(){
        with(viewModel){
            isLoading.observe(this@DetailsMovieActivity) {
                handlerProgressBar(it)
                handlerContainerVisibility(!it)
            }

            isError.observe(this@DetailsMovieActivity){
                if(it){
                    showToast(this@DetailsMovieActivity,getString(R.string.error_toast))
                    finish()
                }
            }

            movie.observe(this@DetailsMovieActivity) { m ->
                with(binding){
                    tvTitle.text = m.originalTitle
                    Picasso.get().load(m.urlImage).into(movieImage)
                    tvDate.text = String.format(getString(R.string.date_details_format),m.releaseDate)
                    tvLanguage.text = String.format(getString(R.string.language_details_format),m.originalLanguage)
                    tvPopularity.text = String.format(getString(R.string.popularity_details_format),m.popularity)
                }
            }
        }
    }
    private fun handlerProgressBar(show: Boolean) {
        binding.iProgressBar.progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun handlerContainerVisibility(show: Boolean){
        binding.clContainer.visibility = if (show) View.VISIBLE else View.GONE
    }
    companion object {
        const val ID_MOVIE = "id_movie"
    }
}