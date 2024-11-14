package com.chh.mvvm.data.model

import com.chh.mvvm.data.mapper.DataToDomainMapper
import com.chh.mvvm.domain.model.PokemonInfo.Type

data class TypeData(
    val name: String,
    val url: String
) : DataToDomainMapper<Type> {

    override fun toDomain(): Type =
        Type(
            name = this.name,
            url = this.url
        )
}
