package com.chh.cleanarchitecture.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.chh.cleanarchitecture.local.model.PokemonNameEntity

@Dao
interface PokemonNameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonName(name: PokemonNameEntity)

}
