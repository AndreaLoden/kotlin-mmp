package io.popularmovies.kmmp.domain

class MovieDetailCase(private val movieReviewRepo: MovieReviewRepo) {
    suspend fun getMovieReviewsRepo(id: String): Either<ApiError, List<ReviewContainer.Review>> =
        movieReviewRepo.getMovieReviews(id)

    suspend fun getMovieTrailersRepo(id: String): Either<ApiError, List<VideoContainer.Video>> =
        movieReviewRepo.getMovieTrailers(id)
}