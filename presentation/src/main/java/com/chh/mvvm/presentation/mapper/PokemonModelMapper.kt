package com.chh.mvvm.presentation.mapper

import com.chh.mvvm.domain.model.Pokemon
import com.chh.mvvm.presentation.model.PokemonModel

internal fun Pokemon.toPresentation(): PokemonModel =
    PokemonModel(
        name = this.name,
        thumbnailUrl = this.getThumbnailUrl(),
        localizedName = this.localizedName,
        confirmedUrl = this.getConfirmedUrl(),
        types = this.types?.sorted()
    )
