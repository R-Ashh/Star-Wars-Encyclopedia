package com.arash.afsharpour.starwarsencyclopedia.ui.activities

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.arash.afsharpour.starwarsencyclopedia.pokemonList.PokemonListScreen
import com.arash.afsharpour.starwarsencyclopedia.pokemondetail.PokemonDetailScreen
import com.arash.afsharpour.starwarsencyclopedia.ui.theme.SWEWhite
import com.arash.afsharpour.starwarsencyclopedia.ui.theme.StarWarsEncyclopediaTheme
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val homeRoute: String = "home_screen"
    private val detailRoute: String = "detail_screen"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StarWarsEncyclopediaTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = homeRoute
                ) {
                    composable(homeRoute) {
                        PokemonListScreen(navController = navController)
                    }

                    composable(
                        "$detailRoute/{dominantColor}/{characterName}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("characterName") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        val dominantColor = remember {
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: SWEWhite
                        }

                        val characterName = remember {
                            it.arguments?.getString("characterName")
                        }

                        PokemonDetailScreen(
                            dominantColor = dominantColor,
                            pokemonName = characterName?.lowercase(Locale.ROOT) ?: "",
                            navController = navController
                        )


                    }
                }
            }
        }
    }
}
