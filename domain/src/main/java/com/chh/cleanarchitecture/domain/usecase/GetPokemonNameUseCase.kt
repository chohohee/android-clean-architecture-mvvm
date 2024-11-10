package com.chh.cleanarchitecture.domain.usecase

import com.chh.cleanarchitecture.domain.model.PokemonName
import com.chh.cleanarchitecture.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonNameUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(name: String): PokemonName = pokemonRepository.getPokemonName(name)

}
