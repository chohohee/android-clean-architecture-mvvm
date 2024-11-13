package com.chh.mvvm.presentation.mapper

import com.chh.mvvm.domain.model.LocalizedName
import com.chh.mvvm.domain.model.PokemonDetail
import com.chh.mvvm.presentation.model.PokemonDetailModel

internal fun PokemonDetail.toPresentation(): PokemonDetailModel =
    PokemonDetailModel(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight,
        types = this.types.map(LocalizedName::toPresentation)
    )