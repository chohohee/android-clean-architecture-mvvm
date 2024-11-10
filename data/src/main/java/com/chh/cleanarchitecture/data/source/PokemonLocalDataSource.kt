package com.chh.cleanarchitecture.data.source

import com.chh.cleanarchitecture.data.model.PokemonData
import com.chh.cleanarchitecture.data.model.PokemonNameData

interface PokemonLocalDataSource {

    suspend fun getPokemonCount(): Int

    suspend fun insertAll(pokemon: List<PokemonData>)

    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonData>

    suspend fun getPokemonName(name: String): PokemonNameData?

    suspend fun insertPokemonName(name: PokemonNameData)

}
