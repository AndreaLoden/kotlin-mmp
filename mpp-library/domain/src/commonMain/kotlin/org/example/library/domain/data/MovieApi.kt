package io.popularmovies.kmmp.data

import io.ktor.client.HttpClient
import io.ktor.client.features.ResponseException
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.popularmovies.kmmp.domain.*
import kotlinx.serialization.json.Json

class MovieApi {
    private val baseEndpoint = "https://api.themoviedb.org/3/movie"
    private val apiKeyQueryParam = "api_key=220e2ce24c38e16c4eafe5708e0e39d4"

    private val client: HttpClient = HttpClient()

    suspend fun getPopularMovies() = try {
        val popularMovies = Json.nonstrict.parse(
            MovieContainer.serializer(),
            client.get { url("$baseEndpoint/popular?$apiKeyQueryParam") }
        ).results

        Either.Right(popularMovies)
    } catch (e: Exception) {
        handleError(e)
    }

    suspend fun getMovieReviews(id: String) = try {
        val movieReviews = Json.nonstrict.parse(
            ReviewContainer.serializer(),
            client.get { url("$baseEndpoint/$id/reviews?$apiKeyQueryParam") }
        ).results

        Either.Right(movieReviews)
    } catch (e: Exception) {
        handleError(e)
    }

    suspend fun getMovieTrailers(id: String) = try {
        val movieTrailers = Json.nonstrict.parse(
            VideoContainer.serializer(),
            client.get { url("$baseEndpoint/$id/videos?$apiKeyQueryParam") }
        ).results

        Either.Right(movieTrailers)
    } catch (e: Exception) {
        handleError(e)
    }

    private fun handleError(exception: Exception): Either<ApiError, Nothing> =
        if (exception is ResponseException) {
            if (exception.response.status.value == 404) {
                Either.Left(
                    ItemNotFoundError
                )
            } else {
                Either.Left(
                    UnknownError(
                        exception.response.status.value
                    )
                )
            }
        } else {
            Either.Left(
                NetworkError
            )
        }
}
