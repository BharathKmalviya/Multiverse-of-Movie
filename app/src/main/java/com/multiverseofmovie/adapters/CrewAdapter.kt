package com.multiverseofmovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.multiverseofmovie.databinding.ItemCrewBinding
import com.multiverseofmovie.models.Crew

// using ListAdapter for better performance
class CrewAdapter : androidx.recyclerview.widget.ListAdapter<Crew, CrewAdapter.ItemViewHolder>(
    // using AsyncDifferConfig to compare items and contents of items in list for better performance and to update only changed items
    AsyncDifferConfig.Builder(object : DiffUtil.ItemCallback<Crew>() {
        override fun areItemsTheSame(oldItem: Crew, newItem: Crew): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Crew, newItem: Crew): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }).build()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemCrewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // passing model to view holder
        holder.bindData(currentList[position])
    }

    inner class ItemViewHolder(private val binding: ItemCrewBinding) : ViewHolder(binding.root) {
        fun bindData(crew: Crew) {
            // binding model to UI
            binding.model = crew
        }
    }
}