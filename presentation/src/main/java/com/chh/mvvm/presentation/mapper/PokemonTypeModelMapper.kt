package com.chh.mvvm.presentation.mapper

import com.chh.mvvm.domain.model.LocalizedName
import com.chh.mvvm.presentation.model.PokemonTypeModel

fun LocalizedName.toPresentation(): PokemonTypeModel =
    PokemonTypeModel(
        baseName = this.baseName,
        localizedName = this.localizedName
    )
