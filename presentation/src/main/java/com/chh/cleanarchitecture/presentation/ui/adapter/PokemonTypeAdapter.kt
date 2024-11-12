package com.chh.cleanarchitecture.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.chh.cleanarchitecture.presentation.R
import com.chh.cleanarchitecture.presentation.databinding.ItemPokemonTypeBinding
import com.chh.cleanarchitecture.presentation.model.PokemonTypeModel
import com.chh.cleanarchitecture.presentation.ui.adapter.holder.PokemonTypeViewHolder

class PokemonTypeAdapter : ListAdapter<PokemonTypeModel, PokemonTypeViewHolder>(UI_MODEL_COMPARATOR) {

    override fun getItemViewType(position: Int): Int = R.layout.item_pokemon_type

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonTypeViewHolder =
        PokemonTypeViewHolder(ItemPokemonTypeBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: PokemonTypeViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.bind(item)
    }

    companion object {
        private val UI_MODEL_COMPARATOR = object : DiffUtil.ItemCallback<PokemonTypeModel>() {

            override fun areItemsTheSame(oldItem: PokemonTypeModel, newItem: PokemonTypeModel): Boolean =
                oldItem.baseName == newItem.baseName

            override fun areContentsTheSame(oldItem: PokemonTypeModel, newItem: PokemonTypeModel): Boolean =
                oldItem == newItem
        }
    }
}
