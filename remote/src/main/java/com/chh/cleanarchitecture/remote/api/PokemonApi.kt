package com.chh.cleanarchitecture.remote.api

import com.chh.cleanarchitecture.remote.model.PokemonInfoResponse
import com.chh.cleanarchitecture.remote.model.PokemonNameResponse
import com.chh.cleanarchitecture.remote.model.PokemonPagedResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface PokemonApi {

    @GET("pokemon")
    suspend fun fetchPokemonPaged(
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0
    ): PokemonPagedResponse

    @GET("pokemon-species/{name}")
    suspend fun fetchPokemonName(
        @Path("name") name: String
    ): PokemonNameResponse

    @GET("pokemon/{name}")
    suspend fun fetchPokemonInfo(
        @Path("name") name: String
    ): PokemonInfoResponse

}
