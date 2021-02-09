package com.example.pokemonsjc.data.models

import kotlinx.serialization.Serializable

@Serializable
data class PokemonInfo(val id: String, val name: String, val abilities: List<String>, val types: List<String>, val weight: String, val height: String, val imageUrl: String)