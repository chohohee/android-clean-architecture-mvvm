package com.chh.cleanarchitecture.data.model

import com.chh.cleanarchitecture.data.mapper.DataToDomainMapper
import com.chh.cleanarchitecture.domain.model.Name
import com.chh.cleanarchitecture.domain.model.PokemonType

data class PokemonTypeData(
    val id: Int,
    val name: String,
    val names: List<NameData>
) : DataToDomainMapper<PokemonType> {
    override fun toDomain(): PokemonType =
        PokemonType(
            id = this.id,
            name = this.name,
            names = this.names.map {
                Name(
                    language = it.language,
                    name = it.name
                )
            }
        )
}
