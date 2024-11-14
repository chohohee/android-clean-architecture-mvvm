package com.chh.mvvm.data.source

import com.chh.mvvm.data.model.PokemonInfoData
import com.chh.mvvm.data.model.PokemonNameData
import com.chh.mvvm.data.model.PokemonPagedData
import com.chh.mvvm.data.model.PokemonTypeData
import com.chh.mvvm.data.utils.Result

interface PokemonRemoteDataSource {

    suspend fun fetchPokemonPaged(limit: Int, offset: Int): Result<PokemonPagedData>

    suspend fun fetchPokemonName(name: String): Result<PokemonNameData>

    suspend fun fetchPokemonInfo(name: String): Result<PokemonInfoData>

    suspend fun fetchPokemonType(url: String): Result<PokemonTypeData>

}
