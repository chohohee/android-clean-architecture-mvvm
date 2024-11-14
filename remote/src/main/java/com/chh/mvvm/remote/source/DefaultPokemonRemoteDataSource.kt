package com.chh.mvvm.remote.source

import com.chh.mvvm.data.model.PokemonInfoData
import com.chh.mvvm.data.model.PokemonNameData
import com.chh.mvvm.data.model.PokemonPagedData
import com.chh.mvvm.data.model.PokemonTypeData
import com.chh.mvvm.data.source.PokemonRemoteDataSource
import com.chh.mvvm.remote.api.PokemonApi
import javax.inject.Inject
import com.chh.mvvm.data.utils.Result
import com.chh.mvvm.data.utils.safeApiCall

internal class DefaultPokemonRemoteDataSource @Inject constructor(
    private val pokemonApi: PokemonApi
) : PokemonRemoteDataSource {

    override suspend fun fetchPokemonPaged(limit: Int, offset: Int): Result<PokemonPagedData> =
        safeApiCall {
            pokemonApi.fetchPokemonPaged(limit, offset).toData()
        }

    override suspend fun fetchPokemonName(name: String): Result<PokemonNameData> =
        safeApiCall {
            pokemonApi.fetchPokemonName(name).toData()
        }

    override suspend fun fetchPokemonInfo(name: String): Result<PokemonInfoData> =
        safeApiCall {
            pokemonApi.fetchPokemonInfo(name).toData()
        }

    override suspend fun fetchPokemonType(url: String): Result<PokemonTypeData> =
        safeApiCall {
            pokemonApi.fetchPokemonType(url).toData()
        }
}