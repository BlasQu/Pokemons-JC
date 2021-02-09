package com.example.pokemonsjc.feature

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.lifecycleScope
import com.example.pokemonsjc.data.composables.Screens
import com.example.pokemonsjc.data.models.Pokemon
import com.example.pokemonsjc.data.states.PokemonsListState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.android.ext.android.get
import org.koin.android.viewmodel.ext.android.viewModel

class ScreenHolder: AppCompatActivity() {

    private val screens = get<Screens>()
    private val viewmodel by viewModel<PokemonsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            screens.SplashScreen()
        }

        lifecycleScope.launch {
            delay(5000)
            setContent {
                screens.PokemonsScreen(emptyList())
            }
            updateLazyColumn()
        }
    }

    private fun updateLazyColumn() {
        lifecycleScope.launch {
            viewmodel.pokemons.collect {
                setContent {
                    when (it) {
                        is PokemonsListState.Success -> {
                            screens.PokemonsScreen(it.list)
                        }
                        else -> screens.PokemonsScreen(emptyList())
                    }
                }
            }
        }
    }
}