package com.chh.cleanarchitecture.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PokemonResponse(
    @SerialName("name") val name: String,
    @SerialName("url") val url: String,
)