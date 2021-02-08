package com.example.pokemonsjc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private val color_yellow = ContextCompat.getColor(this, R.color.yellow)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen()
        }

        lifecycleScope.launch {
            delay(5000)
            setContent {
                PokemonsScreen()
            }
        }
    }

    @Preview
    @Composable
    fun PokemonsScreen() {
        ConstraintLayout(modifier = Modifier
                .background(color = Color.White)
                .fillMaxWidth()
                .fillMaxHeight()) {
            TopAppBar(title = { Text("Pokemons") },
                    backgroundColor = Color(color_yellow),
                    elevation = 8.dp
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