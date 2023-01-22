package com.multiverseofmovie.api_services

import com.google.gson.JsonElement
import com.multiverseofmovie.models.MovieCreditsModel
import com.multiverseofmovie.models.MovieDetailsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

/*
* ApiServices interface is to declare all the api calls using retrofit
* */

interface ApiServices {

    @GET("3/movie/453395")
    suspend fun getMovieDetails(@QueryMap params: HashMap<String, String>): Response<JsonElement>

    @GET("3/movie/453395/credits")
    suspend fun getMovieCredits(@QueryMap params: HashMap<String, String>): Response<JsonElement>
}