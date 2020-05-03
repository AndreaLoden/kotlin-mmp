package io.popularmovies.kmmp.data

import io.popularmovies.kmmp.domain.MovieContainer
import io.popularmovies.kmmp.domain.ApiError
import io.popularmovies.kmmp.domain.Either
import io.popularmovies.kmmp.domain.PopularListMovieRepo

class PopularListMovieRepoImpl(private val api: MovieApi) :
    PopularListMovieRepo {
    override suspend fun getPopularMovies(): Either<ApiError, List<MovieContainer.Movie>> =
        api.getPopularMovies()
}