package com.chh.mvvm.data.model

import com.chh.mvvm.data.mapper.DataToDomainMapper
import com.chh.mvvm.domain.model.PokemonName

data class PokemonNameData(
    val name: String,
    val names: List<NameData>
) : DataToDomainMapper<PokemonName> {
    override fun toDomain(): PokemonName =
        PokemonName(
            name = this.name,
            names = this.names.map(NameData::toDomain)
        )
}

