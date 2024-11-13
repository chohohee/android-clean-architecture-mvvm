package com.chh.mvvm.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PokemonModel(
    val name: String,
    val thumbnailUrl: String,
    val localizedName: String?,
    val confirmedUrl: String
) : Parcelable {

    fun unconfirmed(): Boolean = localizedName.isNullOrEmpty()
}