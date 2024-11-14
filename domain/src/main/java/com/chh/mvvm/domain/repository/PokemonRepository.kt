package com.chh.mvvm.domain.repository

import androidx.paging.PagingData
import com.chh.mvvm.domain.model.Pokemon
import com.chh.mvvm.domain.model.PokemonInfo
import com.chh.mvvm.domain.model.PokemonName
import com.chh.mvvm.domain.model.PokemonType
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemonList(): Flow<PagingData<Pokemon>>

    fun getPokemonNameLast(): Flow<List<PokemonName>>

    fun getPokemonInfoLast(): Flow<List<PokemonInfo>>

    suspend fun getPokemonName(name: String): PokemonName

    suspend fun getPokemonInfo(name: String): PokemonInfo

    suspend fun getPokemonType(type: PokemonInfo.Type): PokemonType

}