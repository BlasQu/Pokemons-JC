package com.example.pokemonsjc.data.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokemonsjc.R
import com.example.pokemonsjc.data.models.Pokemon

@Composable
    fun PokemonItem(
    pokemon: Pokemon,
    click: () -> Unit
) {
        Card(shape = RoundedCornerShape(2.dp),
                backgroundColor = Color.White,
                elevation = 8.dp,
                modifier = Modifier
                        .fillMaxWidth()
                        .preferredHeight(150.dp)
                        .padding(2.dp)) {
            ConstraintLayout(modifier = Modifier.fillMaxSize()) {
                val text_id = createRef()
                val text_pokemon_id = createRef()
                val text_pokemon_name = createRef()
                val img_pokemon = createRef()
                val gl_horizontal = createGuidelineFromTop(0.5f)

                Image(bitmap = imageResource(id = R.drawable.no_image_found),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.padding(16.dp).aspectRatio(1f).fillMaxHeight()
                        .constrainAs(img_pokemon) {
                            start.linkTo(parent.start)
                            top.linkTo(parent.top)
                        })

                Text(text = "ID: ", fontSize = 20.sp, maxLines = 1, fontWeight = FontWeight.Bold, color = Color.Black,
                        modifier = Modifier.padding(16.dp).constrainAs(text_id) {
                            bottom.linkTo(gl_horizontal)
                            start.linkTo(img_pokemon.end)
                        })

                Text(text = pokemon.id.toString(), fontSize = 20.sp, maxLines = 1, fontWeight = FontWeight.Bold, color = Color.Black,
                        modifier = Modifier.padding(16.dp).constrainAs(text_pokemon_id) {
                            bottom.linkTo(gl_horizontal)
                            start.linkTo(text_id.end)
                        })

                Text(text = pokemon.name, fontSize = 24.sp, maxLines = 2, color = Color.Black,
                        modifier = Modifier.padding(16.dp).constrainAs(text_pokemon_name) {
                            top.linkTo(gl_horizontal)
                            start.linkTo(img_pokemon.end)
                        })
            }
        }
    }