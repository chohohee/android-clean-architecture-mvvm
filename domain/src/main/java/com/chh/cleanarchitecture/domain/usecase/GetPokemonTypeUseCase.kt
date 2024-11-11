package com.chh.cleanarchitecture.domain.usecase

import com.chh.cleanarchitecture.domain.model.LocalizedName
import com.chh.cleanarchitecture.domain.model.PokemonInfo
import com.chh.cleanarchitecture.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonTypeUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val getLocalizedNameUseCase: GetLocalizedNameUseCase
) {

    suspend operator fun invoke(type: PokemonInfo.Type): LocalizedName {
        val pokemonType = pokemonRepository.getPokemonType(type)
        val localizedName = getLocalizedNameUseCase(pokemonType.names)
        return LocalizedName(
            baseName = type.name,
            localizedName = localizedName ?: type.name
        )
    }
}
