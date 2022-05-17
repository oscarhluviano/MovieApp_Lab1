package com.example.movieapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movieapp.R

class MovieAdapter(val onItemListener: OnItemListener) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    var movies = listOf<Movie>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.movie_item, parent, false)
        return MovieViewHolder(view, onItemListener)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    interface OnItemListener {
        fun clickMovie(movie: Movie)
    }

    class MovieViewHolder(view: View, onItemListener: MovieAdapter.OnItemListener) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private val title: TextView = view.findViewById(R.id.article_title)
        private val description: TextView = view.findViewById(R.id.article_description)
        private val featuredImage: ImageView = view.findViewById(R.id.featured_image)

        private val onItemListener = onItemListener
        private lateinit var item: Movie

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View){
            onItemListener.clickMovie(item)
        }

        fun bind(movie: Movie) {
            title.text = movie.title
            description.text = movie.description
            featuredImage.setImageResource(movie.featuredImage)
            item = movie
        }

    }
}

