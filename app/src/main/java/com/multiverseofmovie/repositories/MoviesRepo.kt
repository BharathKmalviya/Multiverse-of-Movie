package com.multiverseofmovie.repositories

import android.content.Context
import com.multiverseofmovie.api_services.ApiServices
import com.multiverseofmovie.extensions.safeApiCall
import com.multiverseofmovie.models.MovieCreditsModel
import com.multiverseofmovie.models.MovieDetailsModel
import com.multiverseofmovie.utils.Resource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class MoviesRepo @Inject constructor(
    @ApplicationContext val context: Context,
    private val apiServices: ApiServices
) {

    // api call to get movie details
    suspend fun getMovieDetails(apiKey: String, language: String): Resource<MovieDetailsModel> {
        val params = HashMap<String, String>()
        params["api_key"] = apiKey
        params["language"] = language
        // this is api call and using safeApiCall extension function to handle the api call with try catch
        return context.safeApiCall(MovieDetailsModel::class.java){
            apiServices.getMovieDetails(params)
        }
    }

    // api call to get movie credits
    suspend fun getMovieCredits(apiKey: String, language: String): Resource<MovieCreditsModel> {
        val params = HashMap<String, String>()
        params["api_key"] = apiKey
        params["language"] = language
        // this is api call and using safeApiCall extension function to handle the api call with try catch
        return context.safeApiCall(MovieCreditsModel::class.java){
            apiServices.getMovieCredits(params)
        }
    }
}