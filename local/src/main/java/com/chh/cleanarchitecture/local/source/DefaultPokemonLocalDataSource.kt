package com.chh.cleanarchitecture.local.source

import com.chh.cleanarchitecture.data.model.PokemonData
import com.chh.cleanarchitecture.data.source.PokemonLocalDataSource
import com.chh.cleanarchitecture.local.dao.PokemonDao
import com.chh.cleanarchitecture.local.mapper.PokemonEntityMapper
import javax.inject.Inject

internal class DefaultPokemonLocalDataSource @Inject constructor(
    private val pokemonDao: PokemonDao
) : PokemonLocalDataSource {

    override suspend fun getPokemonCount(): Int = pokemonDao.getPokemonCount()

    override suspend fun insertAll(pokemon: List<PokemonData>) {
        pokemonDao.insertAll(pokemon.map(PokemonEntityMapper::toEntity))
    }

    override suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonData> =
        pokemonDao.getPokemonList(limit, offset).map(PokemonEntityMapper::toData)

}
