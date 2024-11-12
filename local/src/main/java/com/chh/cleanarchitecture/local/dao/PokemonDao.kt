package com.chh.cleanarchitecture.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chh.cleanarchitecture.data.model.NameData
import com.chh.cleanarchitecture.local.model.PokemonEntity

@Dao
interface PokemonDao {

    @Query("SELECT COUNT(*) FROM pokemon")
    suspend fun getPokemonCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemon: List<PokemonEntity>)

    @Query("SELECT * FROM pokemon LIMIT :limit OFFSET :offset ")
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonEntity>

    @Query("UPDATE pokemon SET names=:names, localizedBaseName=:name WHERE name = :name")
    suspend fun updatePokemon(names: List<NameData>, name: String)


}
