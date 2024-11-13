package com.chh.mvvm.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chh.mvvm.data.model.NameData

@Entity(tableName = "pokemon_name")
data class PokemonNameEntity(
    @PrimaryKey val name: String,
    val names: List<NameData>,
    val timestamp: Long
)
