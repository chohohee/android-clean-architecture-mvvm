package com.chh.cleanarchitecture.domain.repository

import androidx.paging.PagingData
import com.chh.cleanarchitecture.domain.model.Pokemon
import com.chh.cleanarchitecture.domain.model.PokemonInfo
import com.chh.cleanarchitecture.domain.model.PokemonName
import com.chh.cleanarchitecture.domain.model.PokemonType
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonList(): Flow<PagingData<Pokemon>>

    fun getPokemonNameList(): Flow<List<PokemonName>>

    suspend fun getPokemonName(name: String): PokemonName

    suspend fun getPokemonInfo(name: String): PokemonInfo

    suspend fun getPokemonType(type: PokemonInfo.Type): PokemonType

}