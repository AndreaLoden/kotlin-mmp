package io.popularmovies.kmmp.presentation

import io.popularmovies.kmmp.Background
import io.popularmovies.kmmp.Main
import io.popularmovies.kmmp.domain.MovieDetailCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailPresenter(
    private val movieDetailView: MovieDetailView,
    private val movieDetailCase: MovieDetailCase
) {

    fun start(id: String) {

        GlobalScope.apply {
            launch(Background) {

                val reviews = async { movieDetailCase.getMovieReviewsRepo(id) }
                val trailers = async { movieDetailCase.getMovieTrailersRepo(id) }

                withContext(Main) {
                    movieDetailView.showState(
                        MovieDetailState(
                            reviews.await(),
                            trailers.await()
                        )
                    )
                }
            }
        }
    }
}