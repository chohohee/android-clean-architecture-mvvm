package com.chh.mvvm.domain.usecase

import com.chh.mvvm.domain.model.LocalizedName
import com.chh.mvvm.domain.model.PokemonInfo
import com.chh.mvvm.domain.model.PokemonInfo.Type
import com.chh.mvvm.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val pokemonRepository: PokemonRepository,
    private val getPokemonTypeUseCase: GetPokemonTypeUseCase
) {

    operator fun invoke(name: String): Flow<PokemonInfo> =
        flow {
            val info = pokemonRepository.getPokemonInfo(name)
            getPokemonType(info.types).collect { typeName ->
                info.typeNames.add(typeName)
            }
            info.typeNames.sortBy { it.baseName }

            emit(info)
        }

    private fun getPokemonType(types: List<Type>): Flow<LocalizedName> =
        types.asFlow().flatMapMerge {
            flow {
                emit(getPokemonTypeUseCase(it))
            }
        }
}
