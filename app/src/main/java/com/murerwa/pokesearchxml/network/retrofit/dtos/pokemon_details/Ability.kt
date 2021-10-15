package com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_details

data class Ability(
    val ability: AbilityDetails,
    val is_hidden: Boolean,
    val slot: Int
)