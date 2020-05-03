package io.popularmovies.kmmp.data

import io.popularmovies.kmmp.domain.*

class MovieReviewRepoImpl(private val api: MovieApi) :
    MovieReviewRepo {
    override suspend fun getMovieReviews(id: String): Either<ApiError, List<ReviewContainer.Review>> =
        api.getMovieReviews(id)

    override suspend fun getMovieTrailers(id: String): Either<ApiError, List<VideoContainer.Video>> =
        api.getMovieTrailers(id)
}