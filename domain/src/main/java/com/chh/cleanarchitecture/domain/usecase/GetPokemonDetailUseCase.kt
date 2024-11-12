package com.chh.cleanarchitecture.domain.usecase

import com.chh.cleanarchitecture.domain.model.PokemonDetail
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class GetPokemonDetailUseCase @Inject constructor(
    private val getPokemonNameUseCase: GetPokemonNameUseCase,
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase
) {

    operator fun invoke(name: String): Flow<PokemonDetail> =
        combine(
            getPokemonNameUseCase(name),
            getPokemonInfoUseCase(name)
        ) { pokemonName, pokemonInfo ->
            PokemonDetail(
                id = pokemonInfo.id,
                name = pokemonName,
                height = pokemonInfo.height,
                weight = pokemonInfo.weight,
                types = pokemonInfo.typeNames
            )
        }
}
