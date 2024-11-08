package com.chh.cleanarchitecture.presentation.binding

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chh.cleanarchitecture.presentation.ui.adapter.PokemonPagingAdapter

@BindingAdapter("adapter")
fun RecyclerView.bindAdapter(adapter: PokemonPagingAdapter) {
    this.adapter = adapter
    setHasFixedSize(true)
}

@BindingAdapter("image")
fun AppCompatImageView.bindImage(thumbnailUrl: String) {
    Glide.with(this)
        .load(thumbnailUrl)
        .into(this)
}