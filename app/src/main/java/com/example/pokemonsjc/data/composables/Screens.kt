package com.example.pokemonsjc.data.composables

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.pokemonsjc.R
import com.example.pokemonsjc.data.models.Pokemon

class Screens(app: Application) {

    private val color_yellow = ContextCompat.getColor(app, R.color.yellow)

    @Composable
    fun PokemonsScreen(
        pokemons: List<Pokemon>
    ) {
        ConstraintLayout(modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .fillMaxHeight()) {
            val rv_pokemons = createRef()
            val toolbar = createRef()

            LazyColumn(modifier = Modifier.constrainAs(rv_pokemons) {
                top.linkTo(toolbar.bottom)
            }) {
                itemsIndexed(
                        items = pokemons
                ) { index, item ->
                    PokemonItem(pokemon = item, click = {

                    })
                }
            }

            TopAppBar(
                    title = { Text("Pokemons") },
                    backgroundColor = Color(color_yellow),
                    elevation = 8.dp,
                    modifier = Modifier.constrainAs(toolbar) {
                        top.linkTo(parent.top)
                    }
            )
        }
    }

    @Composable
    fun SplashScreen() {
        ConstraintLayout(modifier = Modifier
                .background(Color(color_yellow))
                .fillMaxSize()) {
            val img_logo = createRef()
            Image(bitmap = imageResource(id = R.drawable.img_pokemon_logo),
                    contentDescription = "",
                    alignment = Alignment.Center,
                    modifier = Modifier.constrainAs(img_logo) {
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    })
        }
    }
}