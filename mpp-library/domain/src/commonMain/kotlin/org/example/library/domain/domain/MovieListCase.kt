package io.popularmovies.kmmp.domain

import io.popularmovies.kmmp.domain.ApiError
import io.popularmovies.kmmp.domain.Either
import io.popularmovies.kmmp.domain.MovieContainer
import io.popularmovies.kmmp.domain.PopularListMovieRepo

class MovieListCase(private val popularMovieListRepo: PopularListMovieRepo) {
    suspend fun getPopularMoviesRepo(): Either<ApiError, List<MovieContainer.Movie>> =
        popularMovieListRepo.getPopularMovies()
}