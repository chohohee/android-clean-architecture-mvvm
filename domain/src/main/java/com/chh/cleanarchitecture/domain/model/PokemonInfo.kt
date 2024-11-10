package com.chh.cleanarchitecture.domain.model

data class PokemonInfo(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<Type>
) {
    data class Type(
        var name: String,
        val url: String
    )
}
