package com.example.pokemonsjc.feature

import com.example.pokemonsjc.data.models.Pokemon
import com.example.pokemonsjc.db.PokemonsDao
import kotlinx.coroutines.flow.Flow

class PokemonsRepository(
    val dao: PokemonsDao
) {

    fun getPokemons(): Flow<List<Pokemon>> = dao.getPokemons()
    suspend fun insertPokemons(list: List<Pokemon>) = dao.insertPokemons(list)
}