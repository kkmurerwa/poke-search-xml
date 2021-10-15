package com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_list

import com.murerwa.pokesearchxml.data.models.Pokemon

data class PokemonDto(
    val name: String,
    val url: String
)

fun PokemonDto.toPokemon(): Pokemon {
    return Pokemon(
        name = name,
        url = url
    )
}