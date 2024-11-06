package com.chh.cleanarchitecture.local.di

import com.chh.cleanarchitecture.data.source.PokemonLocalDataSource
import com.chh.cleanarchitecture.local.source.DefaultPokemonLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindPokemonLocalDataSource(
        local: DefaultPokemonLocalDataSource
    ): PokemonLocalDataSource
}
