package com.chh.cleanarchitecture.presentation.model

import java.util.Locale

data class PokemonDetailModel(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<PokemonTypeModel>
) {

    fun getNo(): String = String.format(Locale.getDefault(),"#%03d", id)
}
