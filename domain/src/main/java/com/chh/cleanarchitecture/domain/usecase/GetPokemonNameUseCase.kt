package com.chh.cleanarchitecture.domain.usecase

import com.chh.cleanarchitecture.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonNameUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val getLocalizedNameUseCase: GetLocalizedNameUseCase
) {

    operator fun invoke(name: String): Flow<String> =
        flow {
            val pokemonName = pokemonRepository.getPokemonName(name)
            val localizedName = getLocalizedNameUseCase(pokemonName.names)
            emit(localizedName ?: name)
        }
}
