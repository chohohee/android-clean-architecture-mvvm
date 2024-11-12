package com.chh.cleanarchitecture.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chh.cleanarchitecture.data.model.NameData

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey val name: String,
    val url: String,
    val names: List<NameData>?
)
