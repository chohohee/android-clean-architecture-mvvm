package com.chh.cleanarchitecture.local.di

import android.content.Context
import androidx.room.Room
import com.chh.cleanarchitecture.local.converter.NameDataConverter
import com.chh.cleanarchitecture.local.converter.TypeDataConverter
import com.chh.cleanarchitecture.local.database.PokemonDatabase
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun providePokemonDatabase(
        @ApplicationContext context: Context,
        nameDataConverter: NameDataConverter,
        typeDataConverter: TypeDataConverter
    ): PokemonDatabase {
        return Room
            .databaseBuilder(context, PokemonDatabase::class.java, "pokemon.db")
            .addTypeConverter(nameDataConverter)
            .addTypeConverter(typeDataConverter)
            .build()
    }

    @Provides
    @Singleton
    fun provideMoshi(): Moshi = Moshi.Builder().addLast(KotlinJsonAdapterFactory()).build()

    @Provides
    @Singleton
    fun provideNameDataConverter(moshi: Moshi): NameDataConverter = NameDataConverter(moshi)

    @Provides
    @Singleton
    fun provideTypeDataConverter(moshi: Moshi): TypeDataConverter = TypeDataConverter(moshi)

}
