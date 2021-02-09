package com.example.pokemonsjc.data.states

import com.example.pokemonsjc.data.models.Pokemon

sealed class PokemonsListState {
    class Success(val list: List<Pokemon>): PokemonsListState()
    object Empty: PokemonsListState()
}