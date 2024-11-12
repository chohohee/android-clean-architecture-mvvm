package com.chh.cleanarchitecture.presentation.model

data class PokemonDetailModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonTypeModel>
)
