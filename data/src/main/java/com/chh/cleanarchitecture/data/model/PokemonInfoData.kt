package com.chh.cleanarchitecture.data.model

import com.chh.cleanarchitecture.data.mapper.DataToDomainMapper
import com.chh.cleanarchitecture.domain.model.PokemonInfo

data class PokemonInfoData(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeData>
) : DataToDomainMapper<PokemonInfo> {
    override fun toDomain(): PokemonInfo =
        PokemonInfo(
            id = this.id,
            name = this.name,
            height = this.height,
            weight = this.weight,
            types = this.types.map(TypeData::toDomain)
        )
}


