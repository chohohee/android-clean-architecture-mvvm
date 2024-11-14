package com.chh.mvvm.local.di

import android.content.Context
import androidx.room.Room
import com.chh.mvvm.local.converter.NameDataConverter
import com.chh.mvvm.local.converter.StringDataConverter
import com.chh.mvvm.local.converter.TypeDataConverter
import com.chh.mvvm.local.database.PokemonDatabase
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
        typeDataConverter: TypeDataConverter,
        stringDataConverter: StringDataConverter
    ): PokemonDatabase {
        return Room
            .databaseBuilder(context, PokemonDatabase::class.java, "pokemon.db")
            .addTypeConverter(nameDataConverter)
            .addTypeConverter(typeDataConverter)
            .addTypeConverter(stringDataConverter)
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

    @Provides
    @Singleton
    fun provideStringDataConverter(moshi: Moshi): StringDataConverter = StringDataConverter(moshi)

}
