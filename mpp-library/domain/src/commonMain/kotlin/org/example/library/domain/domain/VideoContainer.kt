package io.popularmovies.kmmp.domain

import kotlinx.serialization.Serializable

@Serializable
data class VideoContainer(
    val results: List<Video>
) {

    fun getYoutubeTrailers(): List<Video>? {

        val tempVideoList = ArrayList(results)

        if (tempVideoList.size > 0) {

            val videoIterator = results.listIterator()
            while (videoIterator.hasNext()) {
                val (_, _, _, site, type) = videoIterator.next()

                if (!(type == TRAILER_KEYWORD && site == YOUTUBE_KEYWORD)) {
                    //videoIterator.remove()
                }
            }
        }

        return tempVideoList
    }

    @Serializable
    data class Video(
        val id: String?,
        val key: String?,
        val name: String?,
        val site: String?,
        val type: String?
    )

    companion object {
        private const val TRAILER_KEYWORD = "Trailer"
        private const val YOUTUBE_KEYWORD = "YouTube"
    }
}
