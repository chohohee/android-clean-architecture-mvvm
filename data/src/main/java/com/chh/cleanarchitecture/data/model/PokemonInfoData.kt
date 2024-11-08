package com.chh.cleanarchitecture.data.model

data class PokemonInfoData(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeData>
)
