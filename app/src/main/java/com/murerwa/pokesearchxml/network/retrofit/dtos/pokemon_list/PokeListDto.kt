package com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list

data class PokeListDto(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PokemonDto>
)