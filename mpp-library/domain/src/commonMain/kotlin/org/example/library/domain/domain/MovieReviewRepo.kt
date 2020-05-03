package io.popularmovies.kmmp.domain

interface MovieReviewRepo {
    suspend fun getMovieReviews(id: String): Either<ApiError, List<ReviewContainer.Review>>
    suspend fun getMovieTrailers(id: String): Either<ApiError, List<VideoContainer.Video>>
}