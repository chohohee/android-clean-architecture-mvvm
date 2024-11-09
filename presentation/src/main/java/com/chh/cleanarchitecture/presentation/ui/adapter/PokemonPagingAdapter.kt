package com.chh.cleanarchitecture.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.chh.cleanarchitecture.presentation.R
import com.chh.cleanarchitecture.presentation.databinding.ItemPokemonBinding
import com.chh.cleanarchitecture.presentation.model.PokemonModel
import com.chh.cleanarchitecture.presentation.ui.adapter.holder.PokemonViewHolder

class PokemonPagingAdapter(
    private val onPokemonClick: (PokemonModel) -> Unit,
) : PagingDataAdapter<PokemonModel, PokemonViewHolder>(UI_MODEL_COMPARATOR) {

    override fun getItemViewType(position: Int): Int = R.layout.item_pokemon

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder =
        PokemonViewHolder(ItemPokemonBinding.inflate(LayoutInflater.from(parent.context), parent,false), onPokemonClick)

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val item = getItem(position) ?: return
        holder.bind(item)
    }

    companion object {
        private val UI_MODEL_COMPARATOR = object : DiffUtil.ItemCallback<PokemonModel>() {
            override fun areItemsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean =
                oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: PokemonModel, newItem: PokemonModel): Boolean =
                oldItem == newItem
        }
    }
}
