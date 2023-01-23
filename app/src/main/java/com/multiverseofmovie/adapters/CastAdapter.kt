package com.multiverseofmovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.multiverseofmovie.databinding.ItemCastBinding
import com.multiverseofmovie.models.Cast

// using ListAdapter for better performance
class CastAdapter : androidx.recyclerview.widget.ListAdapter<Cast, CastAdapter.ItemViewHolder>(
    // using AsyncDifferConfig to compare items and contents of items in list for better performance and to update only changed items
    AsyncDifferConfig.Builder(object : DiffUtil.ItemCallback<Cast>() {
        override fun areItemsTheSame(oldItem: Cast, newItem: Cast): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cast, newItem: Cast): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }).build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemCastBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // passing model to view holder
        holder.bindData(currentList[position])
    }

    inner class ItemViewHolder(private val binding: ItemCastBinding) : ViewHolder(binding.root) {
        fun bindData(cast: Cast) {
            // binding model to UI
            binding.model = cast
        }
    }
}