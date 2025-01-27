package com.chh.mvvm.data.source

import com.chh.mvvm.data.model.PokemonData
import com.chh.mvvm.data.model.PokemonInfoData
import com.chh.mvvm.data.model.PokemonNameData
import com.chh.mvvm.data.model.PokemonTypeData
import kotlinx.coroutines.flow.Flow

interface PokemonLocalDataSource {

    suspend fun getPokemonCount(): Int

    suspend fun insertAll(pokemon: List<PokemonData>)

    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonData>

    fun getPokemonNameLast(): Flow<List<PokemonNameData>>

    fun getPokemonInfoLast(): Flow<List<PokemonInfoData>>

    suspend fun updatePokemonNames(name: PokemonNameData)

    suspend fun updatePokemonTypes(info: PokemonInfoData)

    suspend fun getPokemonName(name: String): PokemonNameData?

    suspend fun insertPokemonName(name: PokemonNameData)

    suspend fun getPokemonInfo(name: String): PokemonInfoData?

    suspend fun insertPokemonInfo(info: PokemonInfoData)

    suspend fun getPokemonType(name: String): PokemonTypeData?

    suspend fun insertPokemonType(type: PokemonTypeData)

}
