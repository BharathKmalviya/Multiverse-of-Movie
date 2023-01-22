package com.multiverseofmovie.api_services

import com.multiverseofmovie.models.MovieCreditsModel
import com.multiverseofmovie.models.MovieDetailsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

/*
* ApiServices interface is to declare all the api calls using retrofit
* */

interface ApiServices {

    @GET
    suspend fun getMovieDetails(@QueryMap params: HashMap<String, String>): Response<MovieDetailsModel>

    @GET("credits")
    suspend fun getMovieCredits(@QueryMap params: HashMap<String, String>): Response<MovieCreditsModel>
}