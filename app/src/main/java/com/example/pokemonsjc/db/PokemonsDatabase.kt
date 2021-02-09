package com.example.pokemonsjc.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.pokemonsjc.data.models.Pokemon
import com.example.pokmons.data.converters.JSONConverter

@Database(entities = [Pokemon::class], version = 1, exportSchema = false)
@TypeConverters(JSONConverter::class)
abstract class PokemonsDatabase : RoomDatabase() {
    abstract fun getDao() : PokemonsDao
}