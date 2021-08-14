package com.arash.afsharpour.starwarsencyclopedia.repositories

import com.arash.afsharpour.starwarsencyclopedia.data.remote.response.Pokemon
import com.arash.afsharpour.starwarsencyclopedia.data.remote.response.PokemonList
import com.arash.afsharpour.starwarsencyclopedia.util.Resource

interface IPokemonRepository {

    suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList>

    suspend fun getPokemonDetail(pokemonName: String) : Resource<Pokemon>

}