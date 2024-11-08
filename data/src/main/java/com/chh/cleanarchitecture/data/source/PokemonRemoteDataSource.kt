package com.chh.cleanarchitecture.data.source

import com.chh.cleanarchitecture.data.model.PokemonNameData
import com.chh.cleanarchitecture.data.model.PokemonPagedData
import com.chh.cleanarchitecture.data.util.Result

interface PokemonRemoteDataSource {

    suspend fun fetchPokemonPaged(limit: Int, offset: Int): Result<PokemonPagedData>

    suspend fun fetchPokemonName(name: String): kotlin.Result<PokemonNameData>

}
