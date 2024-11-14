package com.chh.mvvm.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chh.mvvm.data.model.NameData
import com.chh.mvvm.local.model.PokemonEntity

@Dao
interface PokemonDao {

    @Query("SELECT COUNT(*) FROM pokemon")
    suspend fun getPokemonCount(): Int

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(pokemon: List<PokemonEntity>)

    @Query("SELECT * FROM pokemon LIMIT :limit OFFSET :offset ")
    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonEntity>

    @Query("UPDATE pokemon SET names=:names, localizedBaseName=:name WHERE name = :name")
    suspend fun updatePokemonNames(names: List<NameData>, name: String)

    @Query("UPDATE pokemon SET types=:types WHERE name = :name")
    suspend fun updatePokemonTypes(types: List<String>, name: String)

}
