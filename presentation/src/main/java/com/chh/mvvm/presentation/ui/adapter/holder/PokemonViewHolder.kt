package com.chh.mvvm.presentation.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.chh.mvvm.presentation.databinding.ItemPokemonBinding
import com.chh.mvvm.presentation.model.PokemonModel
import com.chh.mvvm.presentation.ui.adapter.PokemonTypeResourceAdapter

class PokemonViewHolder(
    private val binding: ItemPokemonBinding,
    private val onPokemonCLick: (pokemon: PokemonModel) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.adapter = PokemonTypeResourceAdapter()
    }

    fun bind(item: PokemonModel) = with(binding) {
        pokemon = item
        adapter?.submitList(item.types)
        root.setOnClickListener { onPokemonCLick(item) }
    }
}
