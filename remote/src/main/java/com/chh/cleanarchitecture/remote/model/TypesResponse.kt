package com.chh.cleanarchitecture.remote.model

import com.chh.cleanarchitecture.data.model.TypeData
import com.chh.cleanarchitecture.remote.mapper.ResponseToDataMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TypesResponse(
    @SerialName("slot") val slot: Int,
    @SerialName("type") val type: TypeResponse,
) : ResponseToDataMapper<TypeData> {
    override fun toData(): TypeData = TypeData(name = this.type.name, url = this.type.url)

    @Serializable
    internal data class TypeResponse(
        @SerialName("name") val name: String,
        @SerialName("url") val url: String
    )
}

