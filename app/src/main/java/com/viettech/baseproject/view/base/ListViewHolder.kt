package com.viettech.baseproject.view.base

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

/**
 * Each layout's item should include a "item" variable to bind data.
 */
class ListViewHolder<V : ViewBinding>(val binding: V) : RecyclerView.ViewHolder(binding.root)