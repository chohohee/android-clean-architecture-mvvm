package com.chh.cleanarchitecture.remote.model

import com.chh.cleanarchitecture.data.model.NameData
import com.chh.cleanarchitecture.remote.mapper.ResponseToDataMapper
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class NamesResponse(
    @SerialName("language") val language: LanguageResponse,
    @SerialName("name") val name: String,
) : ResponseToDataMapper<NameData> {
    override fun toData(): NameData = NameData(language = this.language.name, name = this.name)

    @Serializable
    internal data class LanguageResponse(
        @SerialName("name") val name: String,
        @SerialName("url") val url: String
    )
}