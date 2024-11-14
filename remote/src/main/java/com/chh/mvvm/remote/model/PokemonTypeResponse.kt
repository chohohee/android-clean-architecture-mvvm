package com.chh.mvvm.remote.model

import com.chh.mvvm.data.model.PokemonTypeData
import com.chh.mvvm.remote.mapper.ResponseToDataMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PokemonTypeResponse(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("names") val names: List<NamesResponse>
) : ResponseToDataMapper<PokemonTypeData> {

    override fun toData(): PokemonTypeData =
        PokemonTypeData(
            id = this.id,
            name = this.name,
            names = this.names.map(NamesResponse::toData)
        )
}