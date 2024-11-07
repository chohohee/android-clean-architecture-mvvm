package com.chh.cleanarchitecture.data.model

import com.chh.cleanarchitecture.data.mapper.DataToDomainMapper
import com.chh.cleanarchitecture.domain.model.Pokemon

data class PokemonData(
    val name: String,
    val url: String,
) : DataToDomainMapper<Pokemon> {
    override fun toDomain(): Pokemon = Pokemon(name = this.name, url = this.url)
}
