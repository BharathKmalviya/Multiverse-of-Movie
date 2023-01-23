package com.multiverseofmovie.models


import android.os.Parcelable
import android.text.TextUtils
import com.google.gson.annotations.SerializedName
import com.multiverseofmovie.constants.AppConstants.IMAGE_BASE_URL
import com.multiverseofmovie.utils.DateTimeHelper
import kotlinx.parcelize.Parcelize
import kotlin.math.ln
import kotlin.math.pow

@Parcelize
data class MovieDetailsModel(
    @SerializedName("adult")
    val adult: Boolean = false,
    @SerializedName("backdrop_path")
    val backdropPath: String = "",
    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollection = BelongsToCollection(),
    @SerializedName("budget")
    val budget: Long = 0,
    @SerializedName("genres")
    val genres: List<Genre> = listOf(),
    @SerializedName("homepage")
    val homepage: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("imdb_id")
    val imdbId: String = "",
    @SerializedName("original_language")
    val originalLanguage: String = "",
    @SerializedName("original_title")
    val originalTitle: String = "",
    @SerializedName("overview")
    val overview: String = "",
    @SerializedName("popularity")
    val popularity: Double = 0.0,
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompany> = listOf(),
    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountry> = listOf(),
    @SerializedName("release_date")
    val releaseDate: String = "",
    @SerializedName("revenue")
    val revenue: Long = 0,
    @SerializedName("runtime")
    val runtime: Int = 0,
    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguage> = listOf(),
    @SerializedName("status")
    val status: String = "",
    @SerializedName("tagline")
    val tagline: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("video")
    val video: Boolean = false,
    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,
    @SerializedName("vote_count")
    val voteCount: Int = 0
) : Parcelable, BaseApiModel() {

    // get the movie genres as comma separated string
    fun getGenresStr(): String = TextUtils.join(", ", genres.map { it.name })

    fun getBackDrop() = IMAGE_BASE_URL + posterPath

    fun getPoster() = IMAGE_BASE_URL + posterPath

    fun getBudgetFormatted() = "$${getFormattedNumber(budget)}"
    fun getRevenueFormatted() = "$${getFormattedNumber(revenue)}"

    fun getFormattedDate(): String {
        return DateTimeHelper.convertDateFormat(
            releaseDate,
            DateTimeHelper.DATE_FORMAT.YYYY_MM_DD,
            DateTimeHelper.DATE_FORMAT.DD_MMM_YYYY
        ) ?: releaseDate
    }

    fun getMovieTime(): String {
        return DateTimeHelper.convertDateFormat(
            releaseDate,
            DateTimeHelper.DATE_FORMAT.YYYY_MM_DD,
            DateTimeHelper.DATE_FORMAT.DD_MMM_YYYY
        ) ?: releaseDate
    }

    // get amount in k, M, B, T
    private fun getFormattedNumber(count: Long): String {
        if (count < 1000) return "" + count
        val exp = (ln(count.toDouble()) / ln(1000.0)).toInt()
        return String.format("%.1f %c", count / 1000.0.pow(exp.toDouble()), "kMGTPE"[exp - 1])
    }
}