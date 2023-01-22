package com.multiverseofmovie.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.multiverseofmovie.R
import com.multiverseofmovie.databinding.ItemCastBinding
import com.multiverseofmovie.databinding.ItemCrewBinding
import com.multiverseofmovie.extensions.loadImage
import com.multiverseofmovie.models.Crew

class CrewAdapter : androidx.recyclerview.widget.ListAdapter<Crew, CrewAdapter.ItemViewHolder>(
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
        holder.bindData(currentList[position])
    }

    inner class ItemViewHolder(val binding: ItemCrewBinding) : ViewHolder(binding.root) {
        fun bindData(crew: Crew) {
            binding.model = crew
        }
    }
}