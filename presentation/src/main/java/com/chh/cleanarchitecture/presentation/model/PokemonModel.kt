package com.chh.cleanarchitecture.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonModel(
    val name: String,
    val thumbnailUrl: String
) : Parcelable