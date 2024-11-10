package com.chh.cleanarchitecture.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chh.cleanarchitecture.local.model.PokemonTypeEntity

@Dao
interface PokemonTypeDao {

    @Query("SELECT * FROM pokemon_type WHERE name = :name")
    suspend fun getPokemonType (name: String): PokemonTypeEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonType(name: PokemonTypeEntity)

}
