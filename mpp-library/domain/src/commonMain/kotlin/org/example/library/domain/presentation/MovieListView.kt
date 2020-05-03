package io.popularmovies.kmmp.presentation

import io.popularmovies.kmmp.domain.ApiError
import io.popularmovies.kmmp.domain.Either
import io.popularmovies.kmmp.domain.MovieContainer

data class MovieState(val popularMoviesResponse: Either<ApiError, List<MovieContainer.Movie>>)

interface MovieListView {
    fun showState(state: MovieState)
}