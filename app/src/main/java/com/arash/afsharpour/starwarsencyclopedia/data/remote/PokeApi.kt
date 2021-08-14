package com.arash.afsharpour.starwarsencyclopedia.data.remote

import com.arash.afsharpour.starwarsencyclopedia.data.remote.response.Pokemon
import com.arash.afsharpour.starwarsencyclopedia.data.remote.response.PokemonList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ) : PokemonList


    @GET("pokemon/{name}")
    suspend fun getPokemonDetail(
        @Path("name") name: String
    ) : Pokemon

}