package com.chh.mvvm.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chh.mvvm.data.model.NameData

@Entity(tableName = "pokemon_type")
data class PokemonTypeEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val names: List<NameData>
)
