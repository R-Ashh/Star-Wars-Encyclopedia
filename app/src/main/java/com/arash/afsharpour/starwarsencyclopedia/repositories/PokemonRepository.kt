package com.arash.afsharpour.starwarsencyclopedia.repositories

import com.arash.afsharpour.starwarsencyclopedia.data.remote.PokeApi
import com.arash.afsharpour.starwarsencyclopedia.data.remote.response.Pokemon
import com.arash.afsharpour.starwarsencyclopedia.data.remote.response.PokemonList
import com.arash.afsharpour.starwarsencyclopedia.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) : IPokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonDetail(pokemonName: String) : Resource<Pokemon> {
        val response = try {
            api.getPokemonDetail(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

}