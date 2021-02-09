package com.example.pokmons.data.converters

import androidx.room.TypeConverter
import com.example.pokemonsjc.data.models.Stats
import com.google.gson.Gson

class JSONConverter {

    @TypeConverter
    fun toJSON(
        stats: List<Stats>
    ): String = Gson().toJson(stats)

    @TypeConverter
    fun toStats(
        json: String
    ): List<Stats> = Gson().fromJson(json, Array<Stats>::class.java).toList()
}