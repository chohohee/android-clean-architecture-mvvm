package com.chh.cleanarchitecture.domain.usecase

import com.chh.cleanarchitecture.domain.model.PokemonInfo
import com.chh.cleanarchitecture.domain.model.PokemonType
import com.chh.cleanarchitecture.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonTypeUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository
) {

    suspend operator fun invoke(type: PokemonInfo.Type): PokemonType = pokemonRepository.getPokemonType(type)
}
