package com.chh.cleanarchitecture.presentation.mapper

import com.chh.cleanarchitecture.domain.model.LocalizedName
import com.chh.cleanarchitecture.domain.model.PokemonDetail
import com.chh.cleanarchitecture.presentation.model.PokemonDetailModel

internal fun PokemonDetail.toPresentation(): PokemonDetailModel =
    PokemonDetailModel(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight,
        types = this.types.map(LocalizedName::toPresentation)
    )