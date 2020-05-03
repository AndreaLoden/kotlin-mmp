package io.popularmovies.kmmp.domain

import kotlinx.serialization.Serializable

@Serializable
data class ReviewContainer(
    val results: List<Review>
) {
    @Serializable
    data class Review(
        val id: String?,
        val author: String?,
        val content: String?,
        val url: String?
    )
}

