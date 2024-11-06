package com.chh.cleanarchitecture.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PokemonPagedResponse(
    @SerialName("count") val count: Int,
    @SerialName("next") val next: String?,
    @SerialName("previous") val previous: String?,
    @SerialName("results") val results: List<PokemonResponse>
) {
    @Serializable
    internal data class PokemonResponse(
        @SerialName("name") val name: String,
        @SerialName("url") val url: String,
    )
}
