package com.chh.cleanarchitecture.local.mapper

import com.chh.cleanarchitecture.data.model.PokemonData
import com.chh.cleanarchitecture.local.model.PokemonEntity

object PokemonEntityMapper : EntityMapper<PokemonData, PokemonEntity> {
    override fun toEntity(data: PokemonData): PokemonEntity {
        return PokemonEntity(name = data.name, url = data.url)
    }

    override fun toData(entity: PokemonEntity): PokemonData {
        return PokemonData(name = entity.name, url = entity.url)
    }
}