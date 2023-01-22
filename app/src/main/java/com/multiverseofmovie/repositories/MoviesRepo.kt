package com.multiverseofmovie.repositories

import android.content.Context
import com.multiverseofmovie.R
import com.multiverseofmovie.api_services.ApiServices
import com.multiverseofmovie.models.BaseApiModel
import com.multiverseofmovie.models.MovieCreditsModel
import com.multiverseofmovie.models.MovieDetailsModel
import com.multiverseofmovie.utils.LogHelper
import com.multiverseofmovie.utils.Resource
import com.multiverseofmovie.utils.isConnectedToInternet
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Response
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
        return safeApiCall(apiServices.getMovieDetails(params))
    }

    // api call to get movie credits
    suspend fun getMovieCredits(apiKey: String, language: String): Resource<MovieCreditsModel> {
        val params = HashMap<String, String>()
        params["api_key"] = apiKey
        params["language"] = language
        return safeApiCall(apiServices.getMovieCredits(params))
    }


    /*
    * this function handle and return response with state to handle in UI
    * */
    private fun <T> safeApiCall(rawResponse: Response<T>): Resource<T> {
        return try {
            if (isConnectedToInternet(context)) {
                if (rawResponse.isSuccessful){
                    return Resource.success(rawResponse as T)
                }else{
                    Resource.error((rawResponse as BaseApiModel)?.statusMessage)
                }
            } else {
                Resource.error(context.getString(R.string.no_internet_connection), data = null)
            }
        } catch (e: Exception) {
            LogHelper.printStackTrace(e)
            return if (isConnectedToInternet(context)) {
                Resource.error(context.getString(R.string.default_error_message), data = null)
            } else {
                Resource.error(context.getString(R.string.no_internet_connection), data = null)
            }
        }
    }
}