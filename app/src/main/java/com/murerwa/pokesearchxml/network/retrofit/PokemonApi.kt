package com.murerwa.pokesearchxml.network.retrofit

import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_details.PokemonDetailsDto
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.PokeListDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("?offset={offset}&limit={limit}")
    suspend fun getPokemonList(
        @Path("offset") offset: Int,
        @Path("limit") limit: Int
    ): PokeListDto

    @GET("{id}")
    suspend fun getPokemonDetails(
        @Path("id") id: Int
    ): PokemonDetailsDto
}