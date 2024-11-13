package com.chh.mvvm.local.mapper

import com.chh.mvvm.data.model.PokemonNameData
import com.chh.mvvm.local.model.PokemonNameEntity

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
