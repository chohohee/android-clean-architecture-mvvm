package com.chh.mvvm.data.di

import com.chh.mvvm.data.paging.PokemonRemoteMediator
import com.chh.mvvm.data.source.PokemonLocalDataSource
import com.chh.mvvm.data.source.PokemonRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object MediatorModule {

    @Provides
    @Singleton
    fun providePokemonRemoteMediator(
        local: PokemonLocalDataSource,
        remote: PokemonRemoteDataSource
    ): PokemonRemoteMediator = PokemonRemoteMediator(local, remote)
}
