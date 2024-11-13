package com.chh.mvvm.remote.model

import com.chh.mvvm.data.model.PokemonNameData
import com.chh.mvvm.remote.mapper.ResponseToDataMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PokemonNameResponse(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("names") val names: List<NamesResponse>
) : ResponseToDataMapper<PokemonNameData> {
    override fun toData(): PokemonNameData =
        PokemonNameData(
            name = this.name,
            names = this.names.map(NamesResponse::toData)
        )
}
