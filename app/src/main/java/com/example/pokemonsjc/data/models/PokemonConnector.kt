package com.example.pokemonsjc.data.models

import kotlinx.serialization.Serializable

@Serializable
data class PokemonConnector(val pokemonId: Int, val pokemonName: String, val imagesUrl: String, val stats: Stats)