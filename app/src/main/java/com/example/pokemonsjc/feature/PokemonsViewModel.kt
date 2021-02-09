package com.example.pokemonsjc.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonsjc.data.models.Pokemon
import com.example.pokemonsjc.data.states.PokemonsListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PokemonsViewModel(
    val repository: PokemonsRepository
): ViewModel() {

    val pokemons = MutableStateFlow<PokemonsListState>(PokemonsListState.Success(emptyList()))

    init {
        viewModelScope.launch {
            repository.getPokemons().collect { pokemonsList ->
                pokemons.value = PokemonsListState.Success(pokemonsList)
            }
        }
    }

    fun insertPokemons(list: List<Pokemon>) {
        viewModelScope.launch {
            repository.insertPokemons(list)
        }
    }
}