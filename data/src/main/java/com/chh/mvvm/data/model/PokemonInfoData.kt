package com.chh.mvvm.data.model

import com.chh.mvvm.data.mapper.DataToDomainMapper
import com.chh.mvvm.domain.model.PokemonInfo

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
