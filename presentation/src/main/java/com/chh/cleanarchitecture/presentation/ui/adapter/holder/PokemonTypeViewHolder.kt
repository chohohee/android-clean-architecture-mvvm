package com.chh.cleanarchitecture.presentation.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.chh.cleanarchitecture.presentation.databinding.ItemPokemonTypeBinding
import com.chh.cleanarchitecture.presentation.model.PokemonTypeModel

class PokemonTypeViewHolder(val binding: ItemPokemonTypeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PokemonTypeModel) = with(binding) {
        type = item
    }
}
