package com.chh.mvvm.presentation.utils

import com.chh.mvvm.presentation.R

object PokemonResourceUtils {
    fun getTypeColor(type: String): Int {
        return when (type) {
            "normal" -> R.color.normal
            "fire" -> R.color.fire
            "water" -> R.color.water
            "electric" -> R.color.electric
            "grass" -> R.color.grass
            "ice" -> R.color.ice
            "fighting" -> R.color.fighting
            "poison" -> R.color.poison
            "ground" -> R.color.ground
            "flying" -> R.color.flying
            "psychic" -> R.color.psychic
            "bug" -> R.color.bug
            "rock" -> R.color.rock
            "ghost" -> R.color.ghost
            "dragon" -> R.color.dragon
            "dark" -> R.color.dark
            "steel" -> R.color.steel
            "fairy" -> R.color.fairy
            else -> R.color.etc
        }
    }

    fun getTypeResource(type: String): Int {
        return when (type) {
            "normal" -> R.drawable.ic_type_normal
            "fire" -> R.drawable.ic_type_fire
            "water" -> R.drawable.ic_type_water
            "electric" -> R.drawable.ic_type_electric
            "grass" -> R.drawable.ic_type_grass
            "ice" -> R.drawable.ic_type_ice
            "fighting" -> R.drawable.ic_type_fighting
            "poison" -> R.drawable.ic_type_poison
            "ground" -> R.drawable.ic_type_ground
            "flying" -> R.drawable.ic_type_flying
            "psychic" -> R.drawable.ic_type_psychic
            "bug" -> R.drawable.ic_type_bug
            "rock" -> R.drawable.ic_type_rock
            "ghost" -> R.drawable.ic_type_ghost
            "dragon" -> R.drawable.ic_type_dragon
            "dark" -> R.drawable.ic_type_dark
            "steel" -> R.drawable.ic_type_steel
            "fairy" -> R.drawable.ic_type_fairy
            else -> R.drawable.ic_type_normal
        }
    }
}
