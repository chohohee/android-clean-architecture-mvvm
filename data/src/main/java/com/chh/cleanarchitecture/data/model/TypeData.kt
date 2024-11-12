package com.chh.cleanarchitecture.data.model

import com.chh.cleanarchitecture.data.mapper.DataToDomainMapper
import com.chh.cleanarchitecture.domain.model.PokemonInfo.Type

data class TypeData(
    val name: String,
    val url: String
) : DataToDomainMapper<Type> {
    override fun toDomain(): Type = Type(name = this.name, url = this.url)
}
