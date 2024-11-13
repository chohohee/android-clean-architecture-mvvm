package com.chh.cleanarchitecture.presentation.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chh.cleanarchitecture.domain.model.PokemonDetail
import com.chh.cleanarchitecture.domain.usecase.GetPokemonDetailUseCase
import com.chh.cleanarchitecture.presentation.mapper.toPresentation
import com.chh.cleanarchitecture.presentation.model.PokemonDetailModel
import com.chh.cleanarchitecture.presentation.model.PokemonModel
import com.chh.cleanarchitecture.presentation.ui.base.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    getPokemonDetailUseCase: GetPokemonDetailUseCase,
) : ViewModel() {

    val pokemon = savedStateHandle.get<PokemonModel>("pokemon")
        ?: throw IllegalStateException("There is no value of the pokemon")

    private val _uiState: MutableStateFlow<UiState> = MutableStateFlow(UiState.Nothing)
    val uiState = _uiState.asStateFlow()

    val pokemonDetail: StateFlow<PokemonDetailModel?> =
        getPokemonDetailUseCase(pokemon.name)
            .map(PokemonDetail::toPresentation)
            .catch { _uiState.value = UiState.Error(it) }
            .onStart { checkLoading() }
            .onCompletion { _uiState.value = UiState.Success }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = null,
            )

    private fun checkLoading() {
        if (pokemon.unconfirmed()) {
            _uiState.value = UiState.Loading
        }
    }
}
