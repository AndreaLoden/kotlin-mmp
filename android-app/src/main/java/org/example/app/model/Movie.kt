package io.popularmovies.kmmp.model

import java.io.Serializable

data class Movie(
    val id: String?,
    val originalTitle: String?,
    val plotSynopsis: String?,
    val userRating: String?,
    val releaseDate: String?, val imageThumbnailUrl: String?
) : Serializable{
    fun getFormattedImageThumbnailUrl(): String = "http:/image.tmdb.org/t/p/w500$imageThumbnailUrl"
}
