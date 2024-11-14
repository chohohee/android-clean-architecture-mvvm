package com.chh.mvvm.domain.usecase

import com.chh.mvvm.domain.model.PokemonCard
import com.chh.mvvm.domain.utils.safeLet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.zip
import javax.inject.Inject

class GetPokemonCardUseCase @Inject constructor(
    private val getPokemonNameLastUseCase: GetPokemonNameLastUseCase,
    private val getPokemonInfoLastUseCase: GetPokemonInfoLastUseCase
) {

    operator fun invoke(): Flow<PokemonCard?> =
        getPokemonNameLastUseCase().zip(getPokemonInfoLastUseCase()) { names, infos ->
            safeLet(names.lastOrNull(), infos.lastOrNull()) { name, info ->
                PokemonCard(
                    baseName = name.baseName,
                    localizedName = name.localizedName,
                    types = info.types.map { it.name }.sorted()
                )
            }
        }
}