package com.chh.cleanarchitecture.remote.source

import com.chh.cleanarchitecture.data.model.PokemonPagedData
import com.chh.cleanarchitecture.data.source.PokemonRemoteDataSource
import com.chh.cleanarchitecture.remote.api.PokemonApi
import javax.inject.Inject
import com.chh.cleanarchitecture.data.util.Result
import com.chh.cleanarchitecture.data.util.safeApiCall

internal class DefaultPokemonRemoteDataSource @Inject constructor(
    private val pokemonApi: PokemonApi
) : PokemonRemoteDataSource {

    override suspend fun fetchPokemonPaged(limit: Int, offset: Int): Result<PokemonPagedData> =
        safeApiCall {
            pokemonApi.fetchPokemonPaged(limit, offset).toData()
        }
}