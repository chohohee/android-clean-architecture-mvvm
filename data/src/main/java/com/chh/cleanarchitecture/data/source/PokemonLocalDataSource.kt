package com.chh.cleanarchitecture.data.source

import com.chh.cleanarchitecture.data.model.PokemonData
import com.chh.cleanarchitecture.data.model.PokemonInfoData
import com.chh.cleanarchitecture.data.model.PokemonNameData
import com.chh.cleanarchitecture.data.model.PokemonTypeData

interface PokemonLocalDataSource {

    suspend fun getPokemonCount(): Int

    suspend fun insertAll(pokemon: List<PokemonData>)

    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonData>

    suspend fun getPokemonName(name: String): PokemonNameData?

    suspend fun insertPokemonName(name: PokemonNameData)

    suspend fun getPokemonInfo(name: String): PokemonInfoData?

    suspend fun insertPokemonInfo(info: PokemonInfoData)

    suspend fun getPokemonType(name: String): PokemonTypeData?

    suspend fun insertPokemonType(type: PokemonTypeData)

}
