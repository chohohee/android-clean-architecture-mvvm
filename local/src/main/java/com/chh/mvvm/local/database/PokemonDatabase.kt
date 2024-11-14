package com.chh.mvvm.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.chh.mvvm.local.converter.NameDataConverter
import com.chh.mvvm.local.converter.StringDataConverter
import com.chh.mvvm.local.converter.TypeDataConverter
import com.chh.mvvm.local.dao.PokemonDao
import com.chh.mvvm.local.dao.PokemonInfoDao
import com.chh.mvvm.local.dao.PokemonNameDao
import com.chh.mvvm.local.dao.PokemonTypeDao
import com.chh.mvvm.local.model.PokemonEntity
import com.chh.mvvm.local.model.PokemonInfoEntity
import com.chh.mvvm.local.model.PokemonNameEntity
import com.chh.mvvm.local.model.PokemonTypeEntity

@Database(
    entities = [
        PokemonEntity::class,
        PokemonNameEntity::class,
        PokemonInfoEntity::class,
        PokemonTypeEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(
    value = [
        NameDataConverter::class,
        TypeDataConverter::class,
        StringDataConverter::class
    ]
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
    abstract fun pokemonNameDao(): PokemonNameDao
    abstract fun pokemonInfoDao(): PokemonInfoDao
    abstract fun pokemonTypeDao(): PokemonTypeDao
}
