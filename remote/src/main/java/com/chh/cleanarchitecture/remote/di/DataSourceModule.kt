package com.chh.cleanarchitecture.remote.di

import com.chh.cleanarchitecture.data.source.PokemonRemoteDataSource
import com.chh.cleanarchitecture.remote.source.DefaultPokemonRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataSourceModule {

    @Binds
    abstract fun bindPokemonRemoteDataSource(
        remote: DefaultPokemonRemoteDataSource
    ): PokemonRemoteDataSource
}
