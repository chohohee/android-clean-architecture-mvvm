package com.chh.cleanarchitecture.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chh.cleanarchitecture.data.model.NameData

@Entity(tableName = "pokemon_type")
data class PokemonTypeEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val names: List<NameData>
)
