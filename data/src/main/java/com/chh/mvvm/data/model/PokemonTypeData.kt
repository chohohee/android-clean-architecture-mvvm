package com.chh.mvvm.data.model

import com.chh.mvvm.data.mapper.DataToDomainMapper
import com.chh.mvvm.domain.model.PokemonType

data class PokemonTypeData(
    val id: Int,
    val name: String,
    val names: List<NameData>
) : DataToDomainMapper<PokemonType> {
    override fun toDomain(): PokemonType =
        PokemonType(
            id = this.id,
            name = this.name,
            names = this.names.map(NameData::toDomain)
        )
}
