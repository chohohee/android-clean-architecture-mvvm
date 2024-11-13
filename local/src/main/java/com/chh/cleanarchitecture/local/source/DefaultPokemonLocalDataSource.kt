package com.chh.cleanarchitecture.local.source

import com.chh.cleanarchitecture.data.model.PokemonData
import com.chh.cleanarchitecture.data.model.PokemonInfoData
import com.chh.cleanarchitecture.data.model.PokemonNameData
import com.chh.cleanarchitecture.data.model.PokemonTypeData
import com.chh.cleanarchitecture.data.source.PokemonLocalDataSource
import com.chh.cleanarchitecture.local.dao.PokemonDao
import com.chh.cleanarchitecture.local.dao.PokemonInfoDao
import com.chh.cleanarchitecture.local.dao.PokemonNameDao
import com.chh.cleanarchitecture.local.dao.PokemonTypeDao
import com.chh.cleanarchitecture.local.mapper.PokemonEntityMapper
import com.chh.cleanarchitecture.local.mapper.toData
import com.chh.cleanarchitecture.local.mapper.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class DefaultPokemonLocalDataSource @Inject constructor(
    private val pokemonDao: PokemonDao,
    private val pokemonNameDao: PokemonNameDao,
    private val pokemonInfoDao: PokemonInfoDao,
    private val pokemonTypeDao: PokemonTypeDao
) : PokemonLocalDataSource {

    override suspend fun getPokemonCount(): Int = pokemonDao.getPokemonCount()

    override suspend fun insertAll(pokemon: List<PokemonData>) {
        pokemonDao.insertAll(pokemon.map(PokemonEntityMapper::toEntity))
    }

    override suspend fun getPokemonList(limit: Int, offset: Int): List<PokemonData> =
        pokemonDao.getPokemonList(limit, offset).map(PokemonEntityMapper::toData)

    override fun getPokemonNameList(): Flow<List<PokemonNameData>> =
        flow {
            pokemonNameDao.getPokemonNameList().collect { result ->
                emit(result.map { it.toData() })
            }
        }

    override suspend fun updatePokemon(name: PokemonNameData) {
        pokemonDao.updatePokemon(name.names, name.name)
    }

    override suspend fun getPokemonName(name: String): PokemonNameData? =
        pokemonNameDao.getPokemonName(name)?.toData()

    override suspend fun insertPokemonName(name: PokemonNameData) {
        pokemonNameDao.insertPokemonName(name.toEntity())
    }

    override suspend fun getPokemonInfo(name: String): PokemonInfoData? =
        pokemonInfoDao.getPokemonInfo(name)?.toData()

    override suspend fun insertPokemonInfo(info: PokemonInfoData) {
        pokemonInfoDao.insertPokemonInfo(info.toEntity())
    }

    override suspend fun getPokemonType(name: String): PokemonTypeData? =
        pokemonTypeDao.getPokemonType(name)?.toData()

    override suspend fun insertPokemonType(type: PokemonTypeData) {
        pokemonTypeDao.insertPokemonType(type.toEntity())
    }

}
