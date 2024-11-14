package com.chh.mvvm.domain.model

data class PokemonCard(
    val baseName: String,
    val localizedName: String,
    val types: List<String>
)