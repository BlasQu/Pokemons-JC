package com.example.pokmons.data.serializables.pokemon.name

import com.example.pokemonsjc.data.models.pokemon.name.Results
import kotlinx.serialization.Serializable

@Serializable
data class PokemonsList(
    val results: List<Results>
)