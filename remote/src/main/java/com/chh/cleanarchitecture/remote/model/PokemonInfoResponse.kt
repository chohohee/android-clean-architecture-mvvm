package com.chh.cleanarchitecture.remote.model

import com.chh.cleanarchitecture.data.model.PokemonInfoData
import com.chh.cleanarchitecture.remote.mapper.ResponseToDataMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PokemonInfoResponse(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("height") val height: Int,
    @SerialName("weight") val weight: Int,
    @SerialName("types") val types: List<TypesResponse>
) : ResponseToDataMapper<PokemonInfoData> {
    override fun toData(): PokemonInfoData =
        PokemonInfoData(
            id = this.id,
            name = this.name,
            height = this.height,
            weight = this.weight,
            types = this.types.map(TypesResponse::toData)
        )
}