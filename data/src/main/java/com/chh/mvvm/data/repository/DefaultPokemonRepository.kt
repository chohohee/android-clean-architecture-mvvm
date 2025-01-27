package com.chh.mvvm.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.chh.mvvm.data.model.PokemonData
import com.chh.mvvm.data.model.PokemonInfoData
import com.chh.mvvm.data.model.PokemonNameData
import com.chh.mvvm.data.paging.PokemonPagingSource
import com.chh.mvvm.data.paging.PokemonRemoteMediator
import com.chh.mvvm.data.source.PokemonLocalDataSource
import com.chh.mvvm.data.source.PokemonRemoteDataSource
import com.chh.mvvm.data.utils.Result
import com.chh.mvvm.domain.model.Pokemon
import com.chh.mvvm.domain.model.PokemonInfo
import com.chh.mvvm.domain.model.PokemonName
import com.chh.mvvm.domain.model.PokemonType
import com.chh.mvvm.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DefaultPokemonRepository @Inject constructor(
    private val local: PokemonLocalDataSource,
    private val remote: PokemonRemoteDataSource,
    private val remoteMediator: PokemonRemoteMediator
) : PokemonRepository {

    override fun getPokemonList(): Flow<PagingData<Pokemon>> {
        return Pager(
            config = PagingConfig(
                pageSize = 100,
                enablePlaceholders = true,
                initialLoadSize = 100
            ),
            remoteMediator = remoteMediator,
            pagingSourceFactory = {
                val pagingSource = PokemonPagingSource(local)
                remoteMediator.addListener { pagingSource.invalidate() }
                pagingSource
            },
        ).flow.map { pagingData ->
            pagingData.map(PokemonData::toDomain)
        }
    }

    override fun getPokemonNameLast(): Flow<List<PokemonName>> =
        flow {
            local.getPokemonNameLast().collect {
                emit(it.map(PokemonNameData::toDomain))
            }
        }

    override fun getPokemonInfoLast(): Flow<List<PokemonInfo>> =
        flow {
            local.getPokemonInfoLast().collect {
                emit(it.map(PokemonInfoData::toDomain))
            }
        }

    override suspend fun getPokemonName(name: String): PokemonName {
        val pokemonName = local.getPokemonName(name)
        if (pokemonName != null) {
            return pokemonName.toDomain()
        }

        when (val result = remote.fetchPokemonName(name)) {
            is Result.Success -> {
                val pokemonNameData = result.data
                local.updatePokemonNames(pokemonNameData)
                local.insertPokemonName(pokemonNameData)
                return pokemonNameData.toDomain()
            }

            is Result.Error -> {
                val pokemonNameData = PokemonNameData(name = name, names = emptyList())
                result.error.message?.let {
                    if (it.contains("404")) {
                        local.updatePokemonNames(pokemonNameData)
                        local.insertPokemonName(pokemonNameData)
                    }
                }
                return pokemonNameData.toDomain()
            }
        }
    }

    override suspend fun getPokemonInfo(name: String): PokemonInfo {
        val pokemonInfo = local.getPokemonInfo(name)
        if (pokemonInfo != null) {
            return pokemonInfo.toDomain()
        }

        when (val result = remote.fetchPokemonInfo(name)) {
            is Result.Success -> {
                val pokemonInfoData = result.data
                local.insertPokemonInfo(pokemonInfoData)
                local.updatePokemonTypes(pokemonInfoData)
                return pokemonInfoData.toDomain()
            }

            is Result.Error -> error("network error")
        }
    }

    override suspend fun getPokemonType(type: PokemonInfo.Type): PokemonType {
        val pokemonType = local.getPokemonType(type.name)
        if (pokemonType != null) {
            return pokemonType.toDomain()
        }

        when (val result = remote.fetchPokemonType(type.url)) {
            is Result.Success -> {
                val pokemonTypeData = result.data
                local.insertPokemonType(pokemonTypeData)
                return pokemonTypeData.toDomain()
            }

            is Result.Error -> error("network error")
        }
    }
}
