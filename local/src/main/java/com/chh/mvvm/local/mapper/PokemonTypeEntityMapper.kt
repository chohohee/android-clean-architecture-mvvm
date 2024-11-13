package com.chh.mvvm.local.mapper

import com.chh.mvvm.data.model.PokemonTypeData
import com.chh.mvvm.local.model.PokemonTypeEntity

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
