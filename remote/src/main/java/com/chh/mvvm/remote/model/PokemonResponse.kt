package com.chh.mvvm.remote.model

import com.chh.mvvm.data.model.PokemonData
import com.chh.mvvm.remote.mapper.ResponseToDataMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PokemonResponse(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String,
) : ResponseToDataMapper<PokemonData> {
    override fun toData(): PokemonData = PokemonData(name = this.name, url = this.url)
}