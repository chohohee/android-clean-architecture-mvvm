package com.chh.mvvm.data.model

import com.chh.mvvm.data.mapper.DataToDomainMapper
import com.chh.mvvm.domain.model.Name

data class NameData(
    val language: String,
    val name: String
) : DataToDomainMapper<Name> {

    override fun toDomain(): Name =
        Name(
            language = this.language,
            name = this.name
        )
}
