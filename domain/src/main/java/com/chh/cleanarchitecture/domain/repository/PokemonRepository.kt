package com.chh.cleanarchitecture.domain.repository

import androidx.paging.PagingData
import com.chh.cleanarchitecture.domain.model.Pokemon
import com.chh.cleanarchitecture.domain.model.PokemonInfo
import com.chh.cleanarchitecture.domain.model.PokemonName
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemon(): Flow<PagingData<Pokemon>>

    suspend fun getPokemonName(name: String): PokemonName

    suspend fun getPokemonInfo(name: String): PokemonInfo

}