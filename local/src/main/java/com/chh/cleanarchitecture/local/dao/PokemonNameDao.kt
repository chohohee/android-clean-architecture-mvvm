package com.chh.cleanarchitecture.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chh.cleanarchitecture.local.model.PokemonNameEntity

@Dao
interface PokemonNameDao {

    @Query("SELECT * FROM pokemon_name WHERE name = :name")
    suspend fun getPokemonName(name: String): PokemonNameEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonName(name: PokemonNameEntity)

}
