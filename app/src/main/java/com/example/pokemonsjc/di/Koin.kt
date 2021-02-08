package com.example.pokemonsjc.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Koin: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@Koin)
            modules(listOf(
                    composablesModule
            ))
        }
    }
}