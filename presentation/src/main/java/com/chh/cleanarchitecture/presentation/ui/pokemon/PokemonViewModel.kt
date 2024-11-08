package com.chh.cleanarchitecture.presentation.ui.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.chh.cleanarchitecture.domain.model.Pokemon
import com.chh.cleanarchitecture.domain.usecase.GetPokemonUseCase
import com.chh.cleanarchitecture.presentation.mapper.toPresentation
import com.chh.cleanarchitecture.presentation.model.PokemonModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    getPokemonUseCase: GetPokemonUseCase,
) : ViewModel() {

    val pokemon: Flow<PagingData<PokemonModel>> =
        getPokemonUseCase()
            .cachedIn(viewModelScope)
            .map { it.map(Pokemon::toPresentation) }
}
