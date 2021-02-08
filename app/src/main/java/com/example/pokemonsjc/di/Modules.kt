package com.example.pokemonsjc.di

import com.example.pokemonsjc.composables.Items
import com.example.pokemonsjc.composables.Screens
import org.koin.dsl.module

val composablesModule = module {
    factory { Screens(get()) }
    factory { Items }
}