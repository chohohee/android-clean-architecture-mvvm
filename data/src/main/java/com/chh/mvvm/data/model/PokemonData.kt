package com.chh.mvvm.data.model

import com.chh.mvvm.data.mapper.DataToDomainMapper
import com.chh.mvvm.domain.model.Pokemon

data class PokemonData(
    val name: String,
    val url: String,
    val names: List<NameData>? = null,
    val localizedBaseName: String? = null
) : DataToDomainMapper<Pokemon> {
    override fun toDomain(): Pokemon =
        Pokemon(
            name = this.name,
            url = this.url,
            names = this.names?.map(NameData::toDomain),
            localizedBaseName = this.localizedBaseName
        )
}
