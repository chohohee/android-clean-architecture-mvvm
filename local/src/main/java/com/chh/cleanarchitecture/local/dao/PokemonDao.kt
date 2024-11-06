package com.chh.cleanarchitecture.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chh.cleanarchitecture.local.model.PokemonEntity

@Dao
interface PokemonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemon: List<PokemonEntity>)

    @Query("SELECT * FROM pokemon LIMIT :limit OFFSET :offset ")
    suspend fun getPokemon(limit: Int, offset: Int): List<PokemonEntity>

}
