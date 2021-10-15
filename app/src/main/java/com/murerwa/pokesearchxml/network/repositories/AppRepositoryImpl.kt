package com.murerwa.pokesearchxml.network.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.murerwa.pokesearchxml.network.PokemonPagingSource
import com.murerwa.pokesearchxml.network.resources.Constants
import com.murerwa.pokesearchxml.network.retrofit.PokemonApi
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_details.PokemonDetailsDto
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.PokeListDto
import com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list.PokemonDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val pokemonApi: PokemonApi
) : AppRepository {
//    override suspend fun getPokemonList(offset: Int, limit: Int): PokeListDto {
//        return pokemonApi.getPokemonList(offset = offset, limit = limit)
//    }

    override suspend fun getPokemonList(): Flow<PagingData<PokemonDto>> {
        val pagingConfig = PagingConfig(pageSize = Constants.DEFAULT_PAGE_SIZE)

        val videoPagingSource = PokemonPagingSource(apiClient = pokemonApi)

        val pager = Pager(config = pagingConfig, pagingSourceFactory = { videoPagingSource })

        return pager.flow
    }


    override suspend fun getPokemonDetails(id: Int): PokemonDetailsDto {
        return pokemonApi.getPokemonDetails(id = id)
    }

}