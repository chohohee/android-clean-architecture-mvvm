package com.chh.mvvm.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.chh.mvvm.local.model.PokemonInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonInfoDao {

    @Query("SELECT * FROM pokemon_info ORDER BY timestamp DESC LIMIT 1")
    fun getPokemonInfoLast(): Flow<List<PokemonInfoEntity>>

    @Query("SELECT * FROM pokemon_info WHERE name = :name")
    suspend fun getPokemonInfo(name: String): PokemonInfoEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonInfo(info: PokemonInfoEntity)

}
