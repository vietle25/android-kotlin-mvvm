package com.viettech.baseproject.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.viettech.baseproject.databinding.ItemMovieBinding
import com.viettech.baseproject.model.movie.MovieModel
import com.viettech.baseproject.view.base.BaseListAdapter
import com.viettech.baseproject.view.base.ListViewHolder

class MovieAdapter() :
    BaseListAdapter<MovieModel, ItemMovieBinding>(DIFF_CALLBACK) {

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieModel>() {
            override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: MovieModel,
                newItem: MovieModel
            ) =
                oldItem == newItem
        }
    }

    override fun createBinding(parent: ViewGroup, viewType: Int): ItemMovieBinding {
        return ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    }

    override fun bindData(holder: ListViewHolder<ItemMovieBinding>, item: MovieModel) {
        holder.binding.titleMovie.text = item.posterPath
    }
}