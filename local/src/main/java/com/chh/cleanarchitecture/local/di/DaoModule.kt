package com.chh.cleanarchitecture.local.di

import com.chh.cleanarchitecture.local.dao.PokemonDao
import com.chh.cleanarchitecture.local.dao.PokemonInfoDao
import com.chh.cleanarchitecture.local.dao.PokemonNameDao
import com.chh.cleanarchitecture.local.dao.PokemonTypeDao
import com.chh.cleanarchitecture.local.database.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Provides
    @Singleton
    fun providePokemonDao(database: PokemonDatabase): PokemonDao = database.pokemonDao()

    @Provides
    @Singleton
    fun providePokemonNameDao(database: PokemonDatabase): PokemonNameDao = database.pokemonNameDao()

    @Provides
    @Singleton
    fun providePokemonInfoDao(database: PokemonDatabase): PokemonInfoDao = database.pokemonInfoDao()

    @Provides
    @Singleton
    fun providePokemonTypeDao(database: PokemonDatabase): PokemonTypeDao = database.pokemonTypeDao()

}
