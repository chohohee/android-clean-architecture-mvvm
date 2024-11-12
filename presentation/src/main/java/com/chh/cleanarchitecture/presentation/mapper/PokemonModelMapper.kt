package com.chh.cleanarchitecture.presentation.mapper

import com.chh.cleanarchitecture.domain.model.Pokemon
import com.chh.cleanarchitecture.presentation.model.PokemonModel

internal fun Pokemon.toPresentation(): PokemonModel =
    PokemonModel(
        name = this.name,
        thumbnailUrl = this.getThumbnailUrl(),
        localizedName = this.localizedName,
        confirmedUrl = this.getConfirmedUrl()
    )
