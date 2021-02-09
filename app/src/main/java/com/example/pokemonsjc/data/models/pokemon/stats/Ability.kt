package com.example.pokemonsjc.data.models.pokemon.stats

import kotlinx.serialization.Serializable

@Serializable
data class Ability(
    val ability: AbilityName,
)