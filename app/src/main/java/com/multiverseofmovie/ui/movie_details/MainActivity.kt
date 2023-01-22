package com.multiverseofmovie.ui.movie_details

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.multiverseofmovie.BuildConfig
import com.multiverseofmovie.R
import com.multiverseofmovie.constants.AppConstants.ENGLISH
import com.multiverseofmovie.databinding.ActivityMainBinding
import com.multiverseofmovie.enums.Status.*
import com.multiverseofmovie.utils.LogHelper
import com.multiverseofmovie.utils.showShortToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setupObservers()
        setupListeners()
        loadData()
    }

    private fun initView() {}
    private fun setupObservers() {
        mViewModel.movieCreditsResponse.observe(this) {
            when (it.status) {
                SUCCESS -> {
                    LogHelper.logD("API_RESPONSE", "MOVIE CREDITS -> ${it.data}")
                }
                ERROR -> {
                    showShortToast(it.message ?: getString(R.string.default_error_message))
                }
                LOADING -> {
                }
            }
        }

        mViewModel.movieDetailsResponse.observe(this) {
            when (it.status) {
                SUCCESS -> {
                    LogHelper.logD("API_RESPONSE", "MOVIE DETAILS -> ${it.data}")
                }
                ERROR -> {
                    showShortToast(it.message ?: getString(R.string.default_error_message))
                }
                LOADING -> {
                }
            }
        }

    }

    private fun setupListeners() {}
    private fun loadData() {

        mViewModel.getMovieCredits(BuildConfig.API_KEY, ENGLISH)
        mViewModel.getMovieCredits(BuildConfig.API_KEY, ENGLISH)
    }


}