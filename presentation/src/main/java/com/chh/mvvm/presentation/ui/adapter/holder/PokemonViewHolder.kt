package com.chh.mvvm.presentation.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.chh.mvvm.presentation.databinding.ItemPokemonBinding
import com.chh.mvvm.presentation.model.PokemonModel

class PokemonViewHolder(
    private val binding: ItemPokemonBinding,
    private val onPokemonCLick: (pokemon: PokemonModel) -> Unit
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PokemonModel) = with(binding) {
        pokemon = item
        root.setOnClickListener { onPokemonCLick(item) }
    }
}