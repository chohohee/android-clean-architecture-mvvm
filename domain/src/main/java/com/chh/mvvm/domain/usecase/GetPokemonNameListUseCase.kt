package com.chh.mvvm.domain.usecase

import com.chh.mvvm.domain.model.LocalizedName
import com.chh.mvvm.domain.model.PokemonName
import com.chh.mvvm.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonNameListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val getLocalizedNameUseCase: GetLocalizedNameUseCase
) {

    operator fun invoke(): Flow<List<LocalizedName>> =
        flow {
            pokemonRepository.getPokemonNameList().collect {
                emit(it.map(::localized))
            }
        }

    fun localized(name: PokemonName): LocalizedName {
        val localizedName = getLocalizedNameUseCase(name.names)
        return LocalizedName(
            baseName = name.name,
            localizedName = localizedName ?: name.name
        )
    }
}
