package com.chh.mvvm.domain.usecase

import androidx.paging.PagingData
import androidx.paging.map
import com.chh.mvvm.domain.model.Pokemon
import com.chh.mvvm.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonListUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val getLocalizedNameUseCase: GetLocalizedNameUseCase
) {

    operator fun invoke(): Flow<PagingData<Pokemon>> =
        flow {
            pokemonRepository.getPokemonList().collect {
                emit(it.map(::localized))
            }
        }

    fun localized(pokemon: Pokemon): Pokemon {
        pokemon.localizedName = getLocalizedNameUseCase(pokemon.names) ?: pokemon.localizedBaseName
        return pokemon
    }
}
