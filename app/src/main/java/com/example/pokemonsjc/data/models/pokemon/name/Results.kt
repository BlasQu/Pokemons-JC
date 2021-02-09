package com.example.pokemonsjc.data.models.pokemon.name

import kotlinx.serialization.Serializable

@Serializable
data class Results(
        val name: String,
        val url: String
        )