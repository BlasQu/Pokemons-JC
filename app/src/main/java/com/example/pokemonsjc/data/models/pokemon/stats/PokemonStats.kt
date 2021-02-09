package com.example.pokemonsjc.data.models.pokemon.stats

import com.example.pokemonsjc.data.models.pokemon.type.Type
import kotlinx.serialization.Serializable

@Serializable
data class PokemonStats(
    val abilities: List<Ability>,
    val height: Int,
    val weight: Int,
    val types: List<Type>,
    val forms: List<Forms>
)