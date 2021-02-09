package com.example.pokemonsjc.di

import android.app.Application
import androidx.room.Room
import com.example.pokemonsjc.data.composables.Screens
import com.example.pokemonsjc.db.PokemonsDao
import com.example.pokemonsjc.db.PokemonsDatabase
import com.example.pokemonsjc.feature.PokemonsRepository
import com.example.pokemonsjc.feature.PokemonsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val composablesModule = module {
    factory { Screens(get()) }
}

val databaseModule = module {
    fun provideDatabase(
        app: Application
    ): PokemonsDatabase =
        Room.databaseBuilder(app, PokemonsDatabase::class.java, "pokemons_database").build()

    fun provideDao(db: PokemonsDatabase): PokemonsDao =
        db.getDao()

    single { provideDatabase(get()) }
    single { provideDao(get()) }
}

val architectureModule = module {
    single { PokemonsRepository(get()) }
    viewModel { PokemonsViewModel(get()) }
}
