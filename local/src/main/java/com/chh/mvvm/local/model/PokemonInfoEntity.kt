package com.chh.mvvm.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.chh.mvvm.data.model.TypeData

@Entity(tableName = "pokemon_info")
data class PokemonInfoEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeData>
)
