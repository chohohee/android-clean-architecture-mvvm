package com.chh.cleanarchitecture.data.model

import com.chh.cleanarchitecture.data.mapper.DataToDomainMapper
import com.chh.cleanarchitecture.domain.model.Name

data class NameData(
    val language: String,
    val name: String
) : DataToDomainMapper<Name> {
    override fun toDomain(): Name = Name(language = this.language, name = this.name)
}
