package io.popularmovies.kmmp.domain

interface PopularListMovieRepo {
    suspend fun getPopularMovies(): Either<ApiError, List<MovieContainer.Movie>>
}