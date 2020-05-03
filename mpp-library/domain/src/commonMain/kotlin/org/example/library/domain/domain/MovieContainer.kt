package io.popularmovies.kmmp.domain

import kotlinx.serialization.Serializable

@Serializable
data class MovieContainer(
    val results: List<Movie>
) {
    @Serializable
    data class Movie(
        val id: String?,
        val title: String?,
        val overview: String?,
        val vote_average: String?,
        val release_date: String?,
        val poster_path: String?
    ) {
        fun getFormattedImageThumbnailUrl(): String = "http:/image.tmdb.org/t/p/w500$poster_path"
    }
}
