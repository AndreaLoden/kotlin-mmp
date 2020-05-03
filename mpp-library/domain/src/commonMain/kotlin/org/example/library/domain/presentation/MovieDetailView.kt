package io.popularmovies.kmmp.presentation

import io.popularmovies.kmmp.domain.ReviewContainer
import io.popularmovies.kmmp.domain.VideoContainer
import io.popularmovies.kmmp.domain.ApiError
import io.popularmovies.kmmp.domain.Either

data class MovieDetailState(
    val movieReviewsResponse: Either<ApiError, List<ReviewContainer.Review>>,
    val movieTrailers: Either<ApiError, List<VideoContainer.Video>>
)

interface MovieDetailView {
    fun showState(state: MovieDetailState)
}