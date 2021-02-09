package com.example.pokemonsjc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.lifecycleScope
import com.example.pokemonsjc.composables.Screens
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class SplashActivity : AppCompatActivity() {

    private val screens by inject<Screens>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            screens.SplashScreen()
        }

        lifecycleScope.launch {
            delay(5000)
            setContent {
                screens.PokemonsScreen()
            }
        }
    }
}