package com.chh.cleanarchitecture.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chh.cleanarchitecture.local.dao.PokemonDao
import com.chh.cleanarchitecture.local.model.PokemonEntity

@Database(
    entities = [
        PokemonEntity::class
    ],
    version = 1,
    exportSchema = false,
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}
