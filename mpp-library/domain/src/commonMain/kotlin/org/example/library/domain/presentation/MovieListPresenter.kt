package io.popularmovies.kmmp.presentation

import io.popularmovies.kmmp.Background
import io.popularmovies.kmmp.Main
import io.popularmovies.kmmp.domain.MovieListCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieListPresenter(
    private val movieListView: MovieListView,
    private val movieListCase: MovieListCase
) {

    fun start() {
        GlobalScope.apply {
            launch(Background) {
                val s = movieListCase.getPopularMoviesRepo()
                println(s)
                withContext(Main) {
                    movieListView.showState(
                        MovieState(
                            s
                        )
                    )
                }
            }
        }
    }
}