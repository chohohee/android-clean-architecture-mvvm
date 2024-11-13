package com.chh.mvvm.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chh.mvvm.local.model.PokemonNameEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonNameDao {

    @Query("SELECT * FROM pokemon_name ORDER BY timestamp ASC")
    fun getPokemonNameList(): Flow<List<PokemonNameEntity>>

    @Query("SELECT * FROM pokemon_name WHERE name = :name")
    suspend fun getPokemonName(name: String): PokemonNameEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonName(name: PokemonNameEntity)

}
