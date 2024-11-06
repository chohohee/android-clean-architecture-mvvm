package com.chh.cleanarchitecture.domain.usecase

import androidx.paging.PagingData
import com.chh.cleanarchitecture.domain.model.Pokemon
import com.chh.cleanarchitecture.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    operator fun invoke(): Flow<PagingData<Pokemon>> = pokemonRepository.getPokemon()
}
