package com.chh.mvvm.domain.usecase

import com.chh.mvvm.domain.model.LocalizedName
import com.chh.mvvm.domain.model.PokemonInfo
import com.chh.mvvm.domain.repository.PokemonRepository
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
