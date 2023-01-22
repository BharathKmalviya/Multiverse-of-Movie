package com.multiverseofmovie.ui.movie_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.multiverseofmovie.models.MovieCreditsModel
import com.multiverseofmovie.models.MovieDetailsModel
import com.multiverseofmovie.repositories.MoviesRepo
import com.multiverseofmovie.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val moviesRepo: MoviesRepo):ViewModel() {

    private val _movieDetailsResponse  = MutableLiveData<Resource<MovieDetailsModel>>()
    val movieDetailsResponse  : LiveData<Resource<MovieDetailsModel>> = _movieDetailsResponse

    private val _movieCreditsResponse  = MutableLiveData<Resource<MovieCreditsModel>>()
    val movieCreditsResponse  : LiveData<Resource<MovieCreditsModel>> = _movieCreditsResponse


    fun getMovieDetails(apiKey:String, language:String){
        viewModelScope.launch {
            _movieDetailsResponse.postValue(Resource.loading())
            _movieDetailsResponse.postValue(moviesRepo.getMovieDetails(apiKey, language))
        }
    }

    fun getMovieCredits(apiKey:String, language:String){
        viewModelScope.launch {
            _movieCreditsResponse.postValue(Resource.loading())
            _movieCreditsResponse.postValue(moviesRepo.getMovieCredits(apiKey, language))
        }
    }
}