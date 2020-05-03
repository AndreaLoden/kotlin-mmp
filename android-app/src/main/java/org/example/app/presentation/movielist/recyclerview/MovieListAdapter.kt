package org.example.app.presentation.movielist.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import io.popularmovies.kmmp.domain.MovieContainer
import com.squareup.picasso.Picasso
import org.example.app.R
import java.util.*

internal class MovieListAdapter(private val movieClickListener: MovieClickListener) :
    RecyclerView.Adapter<MovieListAdapter.MovieItemViewHolder>() {

    interface MovieClickListener {
        fun onMovieClicked(movie: MovieContainer.Movie, transitionView: View)
    }

    private val movies: MutableList<MovieContainer.Movie> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.movie_item, parent, false)

        return MovieItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(movies[position])

        val movie = movies[position]
        ViewCompat.setTransitionName(holder.moviePoster, movie.id)
        holder.moviePoster.setOnClickListener {
            movieClickListener.onMovieClicked(
                movie,
                holder.moviePoster
            )
        }
    }

    override fun getItemCount(): Int = movies.size

    fun setData(movies: List<MovieContainer.Movie>) {
        this.movies.clear()
        this.movies.addAll(movies)
    }

    fun getData(): ArrayList<MovieContainer.Movie> = ArrayList(this.movies)

    inner class MovieItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var moviePoster: ImageView = itemView.findViewById(R.id.movie_poster)

        fun bind(movie: MovieContainer.Movie) {
            Picasso.get()
                .load(movie.getFormattedImageThumbnailUrl())
                .placeholder(R.drawable.poster_placeholder_loading)
                .error(R.drawable.poster_placeholder_error)
                .into(moviePoster)
        }

    }
}
