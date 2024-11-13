package com.chh.mvvm.data.model

data class PokemonPagedData(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonData>
)
