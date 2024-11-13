package com.chh.cleanarchitecture.local.mapper

import com.chh.cleanarchitecture.data.model.PokemonNameData
import com.chh.cleanarchitecture.local.model.PokemonNameEntity

internal fun PokemonNameEntity.toData(): PokemonNameData =
    PokemonNameData(
        name = this.name,
        names = this.names
    )

internal fun PokemonNameData.toEntity(): PokemonNameEntity =
    PokemonNameEntity(
        name = this.name,
        names = this.names,
        timestamp = System.currentTimeMillis()
    )
