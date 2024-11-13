package com.chh.mvvm.presentation.ui.base

sealed interface UiState {
    data object Nothing : UiState
    data object Loading : UiState
    data object Success : UiState
    data class Error(val error: Throwable?) : UiState
}

fun UiState.throwableOrNull(): Throwable? = if (this is UiState.Error) {
    error
} else {
    null
}