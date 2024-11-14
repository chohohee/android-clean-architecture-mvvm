package com.chh.mvvm.presentation.ui.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.chh.mvvm.presentation.databinding.ItemPokemonTypeResourceBinding

class PokemonTypeResourceViewHolder(val binding: ItemPokemonTypeResourceBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(item: String) = with(binding) {
        type = item
    }
}
