package com.chh.cleanarchitecture.local.mapper

import com.chh.cleanarchitecture.data.model.PokemonInfoData
import com.chh.cleanarchitecture.local.model.PokemonInfoEntity

internal fun PokemonInfoEntity.toData(): PokemonInfoData =
    PokemonInfoData(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight,
        types = this.types
    )

internal fun PokemonInfoData.toEntity(): PokemonInfoEntity =
    PokemonInfoEntity(
        id = this.id,
        name = this.name,
        height = this.height,
        weight = this.weight,
        types = this.types
    )
