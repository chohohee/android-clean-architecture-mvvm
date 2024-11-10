package com.chh.cleanarchitecture.domain.model

data class PokemonType(
    val id: Int,
    val name: String,
    val names: List<Name>
)
