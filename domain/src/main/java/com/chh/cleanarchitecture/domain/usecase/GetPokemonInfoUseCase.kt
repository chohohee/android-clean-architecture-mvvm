package com.chh.cleanarchitecture.domain.usecase

import com.chh.cleanarchitecture.domain.model.PokemonInfo
import com.chh.cleanarchitecture.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(name: String): PokemonInfo = pokemonRepository.getPokemonInfo(name)
}
