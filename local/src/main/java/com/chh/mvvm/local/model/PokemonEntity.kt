package com.chh.mvvm.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chh.mvvm.data.model.NameData

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey val name: String,
    val url: String,
    val names: List<NameData>? = null,
    val localizedBaseName: String? = null
)
