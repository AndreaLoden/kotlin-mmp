package org.example.app.presentation.moviedetail.recyclerview

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.popularmovies.kmmp.domain.VideoContainer.Video
import org.example.app.R
import java.util.*

class TrailersAdapter(private val context: Context) : RecyclerView.Adapter<TrailersAdapter.TrailerItemViewHolder>() {

    private val videoList: MutableList<Video> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrailerItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.video_item, parent, false)

        return TrailerItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TrailerItemViewHolder, position: Int) {
        holder.bind(videoList[position])
    }

    override fun getItemCount(): Int = videoList.size

    fun setData(videos: List<Video>) {
        this.videoList.clear()
        this.videoList.addAll(videos)
    }

    inner class TrailerItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val videoTitle: TextView = itemView.findViewById(R.id.video_title)
        private var video: Video? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(video: Video) {
            this.video = video
            videoTitle.text = video.name
        }

        override fun onClick(v: View) {

            video?.let {

                val appIntent = Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + it.key))
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=" + it.key))

                try {
                    context.startActivity(appIntent)
                } catch (ex: ActivityNotFoundException) {
                    context.startActivity(webIntent)
                }
            }
        }
    }
}
