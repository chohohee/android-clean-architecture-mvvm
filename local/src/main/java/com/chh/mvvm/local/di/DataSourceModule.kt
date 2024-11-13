package com.chh.mvvm.local.di

import com.chh.mvvm.data.source.PokemonLocalDataSource
import com.chh.mvvm.local.source.DefaultPokemonLocalDataSource
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
