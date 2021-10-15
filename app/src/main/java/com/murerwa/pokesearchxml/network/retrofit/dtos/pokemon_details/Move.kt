package com.murerwa.pokesearchxml.network.retrofit.dtos.pokemon_details

data class Move(
    val move: MoveDetails,
    val version_group_details: List<VersionGroupDetail>
)