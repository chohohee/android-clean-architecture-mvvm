package com.chh.mvvm.domain.usecase

import com.chh.mvvm.domain.model.PokemonInfo
import com.chh.mvvm.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPokemonInfoLastUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    operator fun invoke(): Flow<List<PokemonInfo>> = pokemonRepository.getPokemonInfoLast()
}