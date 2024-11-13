package com.chh.mvvm.presentation.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.chh.mvvm.presentation.databinding.ItemPokemonTypeBinding
import com.chh.mvvm.presentation.model.PokemonTypeModel

class PokemonTypeViewHolder(val binding: ItemPokemonTypeBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: PokemonTypeModel) = with(binding) {
        type = item
    }
}
