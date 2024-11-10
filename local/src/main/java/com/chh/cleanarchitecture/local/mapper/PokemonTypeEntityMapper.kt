package com.chh.cleanarchitecture.local.mapper

import com.chh.cleanarchitecture.data.model.PokemonTypeData
import com.chh.cleanarchitecture.local.model.PokemonTypeEntity

internal fun PokemonTypeEntity.toData(): PokemonTypeData =
    PokemonTypeData(
        id = this.id,
        name = this.name,
        names = this.names
    )

internal fun PokemonTypeData.toEntity(): PokemonTypeEntity =
    PokemonTypeEntity(
        id = this.id,
        name = this.name,
        names = this.names
    )
