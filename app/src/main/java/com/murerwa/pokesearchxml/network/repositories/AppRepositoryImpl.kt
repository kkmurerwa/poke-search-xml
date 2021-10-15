package com.murerwa.pokesearchxml.network.repositories

import com.murerwa.pokesearchxml.network.retrofit.PokemonApi
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_details.PokemonDetailsDto
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.PokeListDto
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi
) : AppRepository {
    override suspend fun getPokemonList(offset: Int, limit: Int): PokeListDto {
        return pokemonApi.getPokemonList(offset = offset, limit = limit)
    }


    override suspend fun getPokemonDetails(id: Int): PokemonDetailsDto {
        return pokemonApi.getPokemonDetails(id = id)
    }

}