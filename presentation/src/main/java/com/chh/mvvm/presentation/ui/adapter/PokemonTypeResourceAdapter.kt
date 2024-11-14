package com.chh.mvvm.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.chh.mvvm.presentation.R
import com.chh.mvvm.presentation.databinding.ItemPokemonTypeResourceBinding
import com.chh.mvvm.presentation.ui.adapter.holder.PokemonTypeResourceViewHolder

class PokemonTypeResourceAdapter : ListAdapter<String, PokemonTypeResourceViewHolder>(UI_MODEL_COMPARATOR) {

    override fun getItemViewType(position: Int): Int = R.layout.item_pokemon_type_resource

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonTypeResourceViewHolder =
        PokemonTypeResourceViewHolder(ItemPokemonTypeResourceBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: PokemonTypeResourceViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.bind(item)
    }

    companion object {
        private val UI_MODEL_COMPARATOR = object : DiffUtil.ItemCallback<String>() {

            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean =
                oldItem == newItem
        }
    }
}
