package com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_details

data class PokemonDetailsDto(
    val abilities: List<Ability>,
    val base_experience: Int,
    val forms: List<Form>,
    val height: Int,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val species: Species,
    val sprites: Sprites,
    val stats: List<Stat>,
    val types: List<Type>,
    val weight: Int
)