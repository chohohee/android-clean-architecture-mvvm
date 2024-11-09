package com.chh.cleanarchitecture.presentation.ui.pokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.chh.cleanarchitecture.domain.model.Pokemon
import com.chh.cleanarchitecture.domain.usecase.GetPokemonUseCase
import com.chh.cleanarchitecture.presentation.mapper.toPresentation
import com.chh.cleanarchitecture.presentation.model.PokemonModel
import com.chh.cleanarchitecture.presentation.ui.base.UiState
import com.chh.cleanarchitecture.presentation.util.singleSharedFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    getPokemonUseCase: GetPokemonUseCase,
) : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Loading)
    val uiState = _uiState.asStateFlow()

    private val _navigationState: MutableSharedFlow<NavigationState> = singleSharedFlow()
    val navigationState = _navigationState.asSharedFlow()

    val pokemon: Flow<PagingData<PokemonModel>> =
        getPokemonUseCase()
            .cachedIn(viewModelScope)
            .map { it.map(Pokemon::toPresentation) }

    fun onLoadStateUpdate(loadState: CombinedLoadStates) {
        _uiState.value = when (val refresh = loadState.refresh) {
            is LoadState.Error -> UiState.Error(refresh.error)
            is LoadState.Loading -> UiState.Loading
            else -> UiState.Success
        }
    }

    fun onPokemonClicked(pokemon: PokemonModel) =
        _navigationState.tryEmit(NavigationState.PokemonDetails(pokemon))

    sealed class NavigationState {
        data class PokemonDetails(val pokemon: PokemonModel) : NavigationState()
    }
}
