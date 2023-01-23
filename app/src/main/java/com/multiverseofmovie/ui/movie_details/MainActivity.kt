package com.multiverseofmovie.ui.movie_details

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.multiverseofmovie.BuildConfig
import com.multiverseofmovie.adapters.CastAdapter
import com.multiverseofmovie.adapters.CrewAdapter
import com.multiverseofmovie.constants.AppConstants.ENGLISH
import com.multiverseofmovie.databinding.ActivityMainBinding
import com.multiverseofmovie.enums.Status.ERROR
import com.multiverseofmovie.enums.Status.SUCCESS
import com.multiverseofmovie.utils.LogHelper
import com.multiverseofmovie.utils.showShortToast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val mViewModel by viewModels<MainViewModel>()

    private val mCrewAdapter by lazy {
        CrewAdapter()
    }

    private val mCastAdapter by lazy {
        CastAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // this is to make the status bar transparent
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
        setupObservers()
        setupListeners()
        loadData()
    }

    private fun initView() {
        // this is to set the adapter to recyclerview
        binding.recCrew.adapter = mCrewAdapter
        binding.recCasts.adapter = mCastAdapter
    }

    private fun setupObservers() {
        mViewModel.movieCreditsResponse.observe(this) {
            if (it.status == SUCCESS) {
                LogHelper.logD("API_RESPONSE", "MOVIE CREDITS -> ${it.data}")
                mCastAdapter.submitList(it.data?.cast.orEmpty())
                mCrewAdapter.submitList(it.data?.crew.orEmpty())
            } else if (it.status == ERROR) {
                showShortToast(it.message.orEmpty())
            }
        }

        mViewModel.movieDetailsResponse.observe(this) {
            binding.status = it.status
            if (it.status == SUCCESS) {
                LogHelper.logD("API_RESPONSE", "MOVIE DETAILS -> ${it.data}")
                binding.model = it.data
            } else if (it.status == ERROR) {
                binding.errorLayout.errorMsg.text = it.message
            }
        }
    }

    private fun setupListeners() {
        binding.btnBook.setOnClickListener {
            showShortToast("Under Development")
        }

        binding.errorLayout.retryButton.setOnClickListener {
            mViewModel.getMovieDetails(BuildConfig.API_KEY, ENGLISH)
            mViewModel.getMovieCredits(BuildConfig.API_KEY, ENGLISH)
        }
    }

    private fun loadData() {
        mViewModel.getMovieDetails(BuildConfig.API_KEY, ENGLISH)
        mViewModel.getMovieCredits(BuildConfig.API_KEY, ENGLISH)
    }
}