package io.popularmovies.kmmp

import android.app.Application
import io.popularmovies.kmmp.data.MovieApi
import io.popularmovies.kmmp.data.MovieReviewRepoImpl
import io.popularmovies.kmmp.data.PopularListMovieRepoImpl
import io.popularmovies.kmmp.domain.MovieDetailCase
import io.popularmovies.kmmp.domain.MovieListCase
import io.popularmovies.kmmp.domain.MovieReviewRepo
import io.popularmovies.kmmp.domain.PopularListMovieRepo
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MoviesApplication : Application(), KodeinAware {

    override val kodein by Kodein.lazy {
        import(androidXModule(this@MoviesApplication))

        bind<MovieApi>() with singleton { MovieApi() }

        bind<MovieReviewRepo>() with singleton {
            MovieReviewRepoImpl(
                instance()
            )
        }
        bind<PopularListMovieRepo>() with singleton {
            PopularListMovieRepoImpl(
                instance()
            )
        }

        bind<MovieListCase>() with singleton {
            MovieListCase(
                instance()
            )
        }
        bind<MovieDetailCase>() with singleton {
            MovieDetailCase(
                instance()
            )
        }
    }
}
