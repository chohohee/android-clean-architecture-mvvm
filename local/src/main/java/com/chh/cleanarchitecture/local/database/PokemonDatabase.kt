package com.chh.cleanarchitecture.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chh.cleanarchitecture.local.converter.NameDataConverter
import com.chh.cleanarchitecture.local.dao.PokemonDao
import com.chh.cleanarchitecture.local.dao.PokemonNameDao
import com.chh.cleanarchitecture.local.model.PokemonEntity
import com.chh.cleanarchitecture.local.model.PokemonNameEntity

@Database(
    entities = [
        PokemonEntity::class,
        PokemonNameEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(value = [NameDataConverter::class])
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonNameDao(): PokemonNameDao
}
