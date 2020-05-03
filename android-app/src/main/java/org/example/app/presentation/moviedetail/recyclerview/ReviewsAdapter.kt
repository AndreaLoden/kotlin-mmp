package org.example.app.presentation.moviedetail.recyclerview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.popularmovies.kmmp.domain.ReviewContainer.Review
import org.example.app.R
import java.util.*

class ReviewsAdapter(private val context: Context) :
    RecyclerView.Adapter<ReviewsAdapter.ReviewItemViewHolder>() {

    private val reviewList: MutableList<Review> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewItemViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val view = inflater.inflate(R.layout.review_item, parent, false)

        return ReviewItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReviewItemViewHolder, position: Int) {
        holder.bind(reviewList[position])
    }

    override fun getItemCount(): Int = reviewList.size

    fun setData(reviews: List<Review>) {
        this.reviewList.clear()
        this.reviewList.addAll(reviews)
    }

    inner class ReviewItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        private val reviewTitle: TextView = itemView.findViewById(R.id.review_title)
        private val reviewContent: TextView = itemView.findViewById(R.id.review_content)
        private var review: Review? = null

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(review: Review) {
            this.review = review
            reviewTitle.text =
                String.format("%s %s", context.getString(R.string.detail_review_by), review.author)
            reviewContent.text = review.content
        }

        override fun onClick(v: View) {
            review?.let {
                val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(it.url))
                context.startActivity(webIntent)
            }
        }
    }
}
