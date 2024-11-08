package com.chh.cleanarchitecture.domain.model

data class Pokemon(
    val name: String,
    val url: String
) {

    private fun getIndex(): String = url.split("/".toRegex()).dropLast(1).last()

    fun getThumbnailUrl(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getIndex()}.png"

}