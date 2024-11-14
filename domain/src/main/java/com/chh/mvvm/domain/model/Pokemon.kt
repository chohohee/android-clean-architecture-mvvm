package com.chh.mvvm.domain.model

data class Pokemon(
    val name: String,
    val url: String,
    val names: List<Name>?,
    var localizedBaseName: String?,
    var localizedName: String? = "",
    var types: List<String>? = null
) {

    private fun getIndex(): String = url.split("/".toRegex()).dropLast(1).last()

    fun getThumbnailUrl(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${getIndex()}.png"

    fun getConfirmedUrl(): String =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/showdown/${getIndex()}.gif"
}