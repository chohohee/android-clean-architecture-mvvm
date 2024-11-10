package com.chh.cleanarchitecture.data.model

import com.chh.cleanarchitecture.data.mapper.DataToDomainMapper
import com.chh.cleanarchitecture.domain.model.Name
import com.chh.cleanarchitecture.domain.model.PokemonName

data class PokemonNameData(
    val name: String,
    val names: List<NameData>
) : DataToDomainMapper<PokemonName> {
    override fun toDomain(): PokemonName =
        PokemonName(
            name = this.name,
            names = this.names.map {
                Name(
                    language = it.language,
                    name = it.name
                )
            }
        )
}

