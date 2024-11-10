package com.chh.cleanarchitecture.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.chh.cleanarchitecture.data.model.PokemonData
import com.chh.cleanarchitecture.data.paging.PokemonPagingSource
import com.chh.cleanarchitecture.data.paging.PokemonRemoteMediator
import com.chh.cleanarchitecture.data.source.PokemonLocalDataSource
import com.chh.cleanarchitecture.data.source.PokemonRemoteDataSource
import com.chh.cleanarchitecture.data.util.Result
import com.chh.cleanarchitecture.domain.model.Pokemon
import com.chh.cleanarchitecture.domain.model.PokemonInfo
import com.chh.cleanarchitecture.domain.model.PokemonName
import com.chh.cleanarchitecture.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class DefaultPokemonRepository @Inject constructor(
    private val local: PokemonLocalDataSource,
    private val remote: PokemonRemoteDataSource,
    private val remoteMediator: PokemonRemoteMediator
) : PokemonRepository {

    override fun getPokemon(): Flow<PagingData<Pokemon>> {
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

    override suspend fun getPokemonName(name: String): PokemonName {
        val pokemonName = local.getPokemonName(name)
        if (pokemonName != null) {
            return pokemonName.toDomain()
        }

        when (val result = remote.fetchPokemonName(name)) {
            is Result.Success -> {
                val pokemonNameData = result.data
                local.insertPokemonName(pokemonNameData)
                return pokemonNameData.toDomain()
            }

            is Result.Error -> error("network error")
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
                return pokemonInfoData.toDomain()
            }

            is Result.Error -> error("network error")
        }
    }
}
