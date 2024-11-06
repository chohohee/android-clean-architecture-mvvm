package com.chh.cleanarchitecture.remote.model

import com.chh.cleanarchitecture.data.model.PokemonPagedData
import com.chh.cleanarchitecture.remote.mapper.ResponseToDataMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class PokemonPagedResponse(
    @SerialName("count") val count: Int,
    @SerialName("next") val next: String?,
    @SerialName("previous") val previous: String?,
    @SerialName("results") val results: List<PokemonResponse>
) : ResponseToDataMapper<PokemonPagedData> {
    override fun toData(): PokemonPagedData =
        PokemonPagedData(
            count = this.count,
            next = this.next,
            previous = this.previous,
            results = this.results.map(PokemonResponse::toData)
        )
}