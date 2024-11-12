package com.chh.cleanarchitecture.presentation.mapper

import com.chh.cleanarchitecture.domain.model.LocalizedName
import com.chh.cleanarchitecture.presentation.model.PokemonTypeModel

fun LocalizedName.toPresentation(): PokemonTypeModel =
    PokemonTypeModel(
        baseName = this.baseName,
        localizedName = this.localizedName
    )
