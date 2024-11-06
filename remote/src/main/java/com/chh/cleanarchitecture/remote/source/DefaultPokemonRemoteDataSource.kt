package com.chh.cleanarchitecture.remote.source

import com.chh.cleanarchitecture.data.model.PokemonPagedData
import com.chh.cleanarchitecture.data.source.PokemonRemoteDataSource
import com.chh.cleanarchitecture.remote.api.PokemonApi
import javax.inject.Inject

internal class DefaultPokemonRemoteDataSource @Inject constructor(
    private val pokemonApi: PokemonApi
) : PokemonRemoteDataSource {

    override suspend fun fetchPokemonPaged(limit: Int, offset: Int): Result<PokemonPagedData> =
        kotlin.runCatching { pokemonApi.fetchPokemonPaged(limit, offset).toData() }
}