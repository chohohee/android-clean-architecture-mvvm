package com.chh.cleanarchitecture.data.source

import com.chh.cleanarchitecture.data.model.PokemonPagedData

interface PokemonRemoteDataSource {

    suspend fun fetchPokemonPaged(limit: Int, offset: Int): Result<PokemonPagedData>

}
