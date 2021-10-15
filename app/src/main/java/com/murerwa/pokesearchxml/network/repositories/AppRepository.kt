package com.murerwa.pokesearchxml.network.repositories

import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_details.PokemonDetailsDto
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.PokeListDto

interface AppRepository {
    suspend fun getPokemonList(offset: Int, limit: Int): PokeListDto

    suspend fun getPokemonDetails(id: Int): PokemonDetailsDto
}