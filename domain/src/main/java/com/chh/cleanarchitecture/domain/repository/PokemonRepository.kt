package com.chh.cleanarchitecture.domain.repository

import androidx.paging.PagingData
import com.chh.cleanarchitecture.domain.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {

    fun getPokemon(): Flow<PagingData<Pokemon>>

}