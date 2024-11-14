package com.chh.mvvm.local.mapper

import com.chh.mvvm.data.model.PokemonData
import com.chh.mvvm.local.model.PokemonEntity

object PokemonEntityMapper : EntityMapper<PokemonData, PokemonEntity> {

    override fun toEntity(data: PokemonData): PokemonEntity =
        PokemonEntity(
            name = data.name,
            url = data.url
        )

    override fun toData(entity: PokemonEntity): PokemonData =
        PokemonData(
            name = entity.name,
            url = entity.url,
            names = entity.names,
            localizedBaseName = entity.localizedBaseName,
            types = entity.types
        )

}