package com.example.pokemonsjc.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Stats(
    val abilities: List<String>,
    val weight: Int,
    val height: Int,
    val types: List<String>
)