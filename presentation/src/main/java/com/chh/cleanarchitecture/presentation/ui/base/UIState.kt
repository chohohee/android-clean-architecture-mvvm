package com.chh.cleanarchitecture.presentation.ui.base

sealed interface UiState {
    data object Loading : UiState
    data object Success : UiState
    data class Error(val error: Throwable?) : UiState
}

fun UiState.throwableOrNull(): Throwable? = if (this is UiState.Error) {
    error
} else {
    null
}