package com.chh.cleanarchitecture.data.source

import com.chh.cleanarchitecture.data.model.PokemonData

interface PokemonLocalDataSource {

    suspend fun getPokemonCount(): Int

    suspend fun insertAll(pokemon: List<PokemonData>)

    suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonData>

}
