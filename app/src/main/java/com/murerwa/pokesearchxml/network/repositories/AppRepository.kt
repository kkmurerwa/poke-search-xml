package com.murerwa.pokesearchxml.network.repositories

import androidx.paging.PagingData
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_details.PokemonDetailsDto
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.PokeListDto
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.PokemonDto
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    suspend fun getPokemonList(): Flow<PagingData<PokemonDto>>

    suspend fun getPokemonDetails(id: Int): PokemonDetailsDto
}