package com.chh.mvvm.local.source

import com.chh.mvvm.data.model.PokemonData
import com.chh.mvvm.data.model.PokemonInfoData
import com.chh.mvvm.data.model.PokemonNameData
import com.chh.mvvm.data.model.PokemonTypeData
import com.chh.mvvm.data.source.PokemonLocalDataSource
import com.chh.mvvm.local.dao.PokemonDao
import com.chh.mvvm.local.dao.PokemonInfoDao
import com.chh.mvvm.local.dao.PokemonNameDao
import com.chh.mvvm.local.dao.PokemonTypeDao
import com.chh.mvvm.local.mapper.PokemonEntityMapper
import com.chh.mvvm.local.mapper.toData
import com.chh.mvvm.local.mapper.toEntity
import com.chh.mvvm.local.model.PokemonInfoEntity
import com.chh.mvvm.local.model.PokemonNameEntity
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

    override fun getPokemonNameLast(): Flow<List<PokemonNameData>> =
        flow {
            pokemonNameDao.getPokemonNameLast().collect {
                emit(it.map(PokemonNameEntity::toData))
            }
        }

    override fun getPokemonInfoLast(): Flow<List<PokemonInfoData>> =
        flow {
            pokemonInfoDao.getPokemonInfoLast().collect {
                emit(it.map(PokemonInfoEntity::toData))
            }
        }

    override suspend fun updatePokemonNames(name: PokemonNameData) {
        pokemonDao.updatePokemonNames(name.names, name.name)
    }

    override suspend fun updatePokemonTypes(info: PokemonInfoData) {
        pokemonDao.updatePokemonTypes(info.types.map { it.name }, info.name)
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
