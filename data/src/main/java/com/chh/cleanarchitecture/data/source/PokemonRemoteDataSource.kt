package com.chh.cleanarchitecture.data.source

import com.chh.cleanarchitecture.data.model.PokemonInfoData
import com.chh.cleanarchitecture.data.model.PokemonNameData
import com.chh.cleanarchitecture.data.model.PokemonPagedData
import com.chh.cleanarchitecture.data.model.PokemonTypeData
import com.chh.cleanarchitecture.data.util.Result

interface PokemonRemoteDataSource {

    suspend fun fetchPokemonPaged(limit: Int, offset: Int): Result<PokemonPagedData>

    suspend fun fetchPokemonName(name: String): Result<PokemonNameData>

    suspend fun fetchPokemonInfo(name: String): Result<PokemonInfoData>

    suspend fun fetchPokemonType(url: String): Result<PokemonTypeData>

}
