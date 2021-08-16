package com.arash.afsharpour.starwarsencyclopedia.pokemondetail

import androidx.lifecycle.ViewModel
import com.arash.afsharpour.starwarsencyclopedia.data.remote.response.Pokemon
import com.arash.afsharpour.starwarsencyclopedia.repositories.PokemonRepository
import com.arash.afsharpour.starwarsencyclopedia.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String) : Resource<Pokemon> {
        Timber.d("PokemonName: ${pokemonName}")
        return repository.getPokemonDetail(pokemonName = pokemonName)
    }

}