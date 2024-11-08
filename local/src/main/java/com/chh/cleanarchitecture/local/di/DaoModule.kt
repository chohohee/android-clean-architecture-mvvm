package com.chh.cleanarchitecture.local.di

import com.chh.cleanarchitecture.local.dao.PokemonDao
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

}
